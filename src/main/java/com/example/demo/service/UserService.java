package com.example.demo.service;

import com.example.demo.model.LoginRequest;
import com.example.demo.model.LoginResponse;
import com.example.demo.model.entity.UserEntity;
import com.example.demo.repository.UserRepository;
import com.example.demo.security.jwt.JwtUtils;
import com.example.demo.security.services.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityManager;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;
    @Autowired
    private EntityManager entityManager;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    private JwtUtils jwtUtils;
    @Autowired
    PasswordEncoder encoder;

    // get by id
    public ResponseEntity<?> getById(long id) {
        Optional<UserEntity> user = repository.findById(id);
        return ResponseEntity.ok().body(user);
    }

    // create
    public ResponseEntity<?> create(UserEntity userEntity) {
        Optional<UserEntity> optionalUserEntity = repository.findByUsername(userEntity.getUsername());
        if (optionalUserEntity.isPresent()) {
//                Map<String, String> response = new HashMap<>();
//                response.put("status", "ACCOUNT ALREADY EXIST");
//                return ResponseEntity.ok().body(response);
            throw new ResponseStatusException(HttpStatus.CONFLICT, "TÀI KHOẢN ĐÃ TỒN TẠI");
        }
        try {

            userEntity.setPassword(encoder.encode(userEntity.getPassword()));
            userEntity = repository.save(userEntity);
            return ResponseEntity.ok().body(userEntity);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // update
    public ResponseEntity<?> update(UserEntity userEntity) {
        try {
            Optional<UserEntity> userEntityOptional = repository.findById(userEntity.getId());
            if (!userEntityOptional.isPresent())
                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

//
//            List<UserEntity> list=repository.findByEmailAndPassword(userEntity.getEmail(),userEntity.getPassword());
//            if (list.size()==0)
//                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
            userEntity.setPassword(userEntity.getPassword());
            userEntity = repository.save(userEntity);
            return ResponseEntity.ok().body(userEntity);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<?> login(LoginRequest loginRequest) {
        Optional<UserEntity> userEntityOptional = repository.findByUsername(loginRequest.getUsername());
        if (!userEntityOptional.isPresent()){
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "TÀI KHOẢN KHÔNG TỒN TẠI");
        }
        if (!encoder.matches(loginRequest.getPassword(), userEntityOptional.get().getPassword()))
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "MẬT KHẨU SAI");

        try {

            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            String jwt = jwtUtils.generateJwtToken(authentication);
            userEntityOptional.get().setToken(jwt);
            repository.save(userEntityOptional.get());
            UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
            LoginResponse response=new LoginResponse(userEntityOptional.get().getId(),userEntityOptional.get().getName(),
                    userEntityOptional.get().getUsername(),userEntityOptional.get().getPhone(),userEntityOptional.get().getToken());
            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<?> logout(UserEntity user) {
        try {
            Optional<UserEntity> userOptional = repository.findByUsername(user.getUsername());
            if (!userOptional.isPresent())
                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
            userOptional.get().setToken("");
            user = repository.save(userOptional.get());
            throw new ResponseStatusException(HttpStatus.OK, "THÀNH CÔNG");
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
