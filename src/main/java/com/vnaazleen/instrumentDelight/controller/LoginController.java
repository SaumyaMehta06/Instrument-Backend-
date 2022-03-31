package com.vnaazleen.instrumentDelight.controller;

import com.vnaazleen.instrumentDelight.model.LoginModel;
import com.vnaazleen.instrumentDelight.model.TokenResponseModel;
import com.vnaazleen.instrumentDelight.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class LoginController {

    @Autowired
    private TokenService jwtService;

    @PostMapping({"/login"})
    @CrossOrigin(origins = "http://localhost:4200/")
    public TokenResponseModel createJwtToken(@RequestBody LoginModel jwtRequest) throws Exception {
        return jwtService.createJwtToken(jwtRequest);
    }
}

