package com.poype.easyauth.admin.controller;

import com.poype.easyauth.admin.request.LoginRequest;
import com.poype.easyauth.core.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping(value = "/admin/login")
    public String login(@RequestBody LoginRequest request) {

        return loginService.login(request.getUsername(), request.getPassword());
    }
}
