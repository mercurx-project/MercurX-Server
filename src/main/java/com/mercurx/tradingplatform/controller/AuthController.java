package com.mercurx.tradingplatform.controller;

import com.mercurx.tradingplatform.auth.JwtUtil;
import com.mercurx.tradingplatform.dto.AuthReq;
import com.mercurx.tradingplatform.dto.AuthResponse;
import com.mercurx.tradingplatform.service.Impl.UserServiceImpl;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/authentication")
public class AuthController {

    @Autowired
    private UserServiceImpl userServiceImpl;

    @Autowired
    private JwtUtil jwtTokenUtil;

    @CrossOrigin
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthReq authenticationRequest) throws Exception {

        try {
            UserDetails userDetails = userServiceImpl.loadUserByUsername(authenticationRequest.getUsername());
            if (userDetails != null && userDetails.getPassword().equals(authenticationRequest.getPassword())) {
                // Authentication is successful (Spring Security handles internal process)

                final String jwt = jwtTokenUtil.generateToken(userDetails);
                JsonObject jsonObj = new JsonObject();
                String authToken = new AuthResponse(jwt).getJwt();
                jsonObj.addProperty("JWT", authToken.toString());
                jsonObj.addProperty("ROLE", userDetails.getAuthorities().toArray()[0].toString());
                jsonObj.addProperty("USER", userDetails.getUsername().toString());
                return ResponseEntity.ok(jsonObj.toString());
            }
        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }
        return ResponseEntity.status(HttpStatusCode.valueOf(401)).body("Invalid credentials");
    }

}
