package com.library.libraryService.controller;

import com.library.libraryService.dto.SessionDto;
import com.library.libraryService.service.JwtTokenService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;


@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class SessionController {

    @Autowired
    private AuthenticationManager _authenticationManager;

    @Autowired
    private JwtTokenService _jwtTokenService;


    @PostMapping("/session")
    public String createToken(@RequestBody SessionDto sessionDto) {
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(sessionDto.getUsername(), sessionDto.getPassword());

        Authentication authentication = _authenticationManager.authenticate(token);

        if (authentication.isAuthenticated()) {
            return _jwtTokenService.generateToken(sessionDto.getUsername());
        } else {
            throw new UsernameNotFoundException("Username not found !");
        }
    }

    @GetMapping("/session")
    public String getToken() {
        return  "token info";
    }
}
