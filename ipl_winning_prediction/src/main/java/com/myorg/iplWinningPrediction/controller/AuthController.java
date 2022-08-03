package com.myorg.iplWinningPrediction.controller;

import com.myorg.iplWinningPrediction.model.Login;
import com.myorg.iplWinningPrediction.model.User;
import com.myorg.iplWinningPrediction.repository.UserRepository;
import com.myorg.iplWinningPrediction.security.JwtAuthResponse;
import com.myorg.iplWinningPrediction.security.JwtTokenOperation;
import com.myorg.iplWinningPrediction.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private JwtTokenOperation jwtTokenOperation;

    @PostMapping("/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody Login authenticationRequest) throws Exception {
        logger.info("{} try to authenticate",authenticationRequest.getEmail());
        try {
            authenticate(authenticationRequest.getEmail(), authenticationRequest.getPassword());
        }catch (UsernameNotFoundException e){
            e.printStackTrace();
            throw new Exception("Username not found");
        }


        //final area
        final UserDetails userDetails = this.userService.loadUserByUsername(authenticationRequest.getEmail());
        System.out.println(userDetails.toString());

        final User user = userRepository.findByEmail(authenticationRequest.getEmail());
        final String token = jwtTokenOperation.generateToken(userDetails);
        System.out.println(token);

        return ResponseEntity.ok(new JwtAuthResponse(user,token));
    }
    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED"+ e.getMessage());
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS"+ e.getMessage());
        }
    }
}
