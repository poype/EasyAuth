package com.poype.easyauth.admin.controller;

import com.poype.easyauth.core.model.Identification;
import com.poype.easyauth.core.repository.IdentificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

    @Autowired
    private IdentificationRepository identificationRepository;

    @GetMapping(value = "/test")
    @ResponseBody
    public Identification getIdentification(@RequestParam("username") String username) {
        return identificationRepository.queryByUsername(username);
    }
}
