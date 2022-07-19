package com.poype.easyauth.admin.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @PreAuthorize("hasAuthority('aaa')")
    @GetMapping(value = "/hello")
    @ResponseBody
    public String hello() {
        return "hello";
    }
}
