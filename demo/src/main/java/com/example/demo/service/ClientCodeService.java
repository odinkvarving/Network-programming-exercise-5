package com.example.demo.service;

import com.example.demo.code.ClientCode;
import com.example.demo.repo.ClientCodeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientCodeService {

    @Autowired
    ClientCodeRepo clientCodeRepo;

    public ClientCode getCode(ClientCode code) {
        return clientCodeRepo.getCode(code);
    }
}
