package com.example.demo.controller;

import com.example.demo.code.ClientCode;
import com.example.demo.service.ClientCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/compiler")
public class ClientCodeController {

    @Autowired
    ClientCodeService clientCodeService;

    @PostMapping
    public ClientCode getCode(@RequestBody ClientCode code) {
        return clientCodeService.getCode(code);
    }
}
