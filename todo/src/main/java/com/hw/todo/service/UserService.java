package com.hw.todo.service;


import com.hw.todo.exception.InformationExistsException;
import com.hw.todo.model.User;
import com.hw.todo.model.request.LoginRequest;
import com.hw.todo.model.response.LoginResponse;
import com.hw.todo.repository.UserRepository;
import com.hw.todo.security.JWTUtils;
import com.hw.todo.security.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JWTUtils jwtUtils;
    private final AuthenticationManager authenticationManager;

    @Autowired
    public UserService(UserRepository userRepository, @Lazy PasswordEncoder passwordEncoder,
                       JWTUtils jwtUtils, @Lazy AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtils = jwtUtils;
        this.authenticationManager = authenticationManager;
    }

    public User createUser(User userObject) {
        System.out.println("Service calling createUser ==>");
        if (userRepository.existsByEmailAddress(userObject.getEmailAddress())) {
            throw new InformationExistsException(
                    "Your email has been used to register into the system before, please use another email address");
        }
        userObject.setPassword(passwordEncoder.encode(userObject.getPassword()));
        return userRepository.save(userObject);
    }

    public User findUserByEmailAddress(String email) {
        return userRepository.findUserByEmailAddress(email);
    }

    public ResponseEntity<?> loginUser(LoginRequest loginRequest) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            MyUserDetails myUserDetails = (MyUserDetails) authentication.getPrincipal();
            final String jwt = jwtUtils.generateJwtToken(myUserDetails);
            return ResponseEntity.ok(new LoginResponse(jwt));
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.status(401).body(new LoginResponse("Error: invalid email or password."));
        }
    }
}
