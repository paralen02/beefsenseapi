package com.example.beefsenseapi.controllers;

import com.example.beefsenseapi.serviceimplements.SignedUrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api")
public class SignedUrlController {

    @Autowired
    private SignedUrlService signedUrlService;

    @GetMapping("/generate-signed-url")
    public String generateSignedUrl(@RequestParam String fileName) {
        try {
            return signedUrlService.generateV4PutObjectSignedUrl(fileName);
        } catch (IOException e) {
            // Handle the exception and return an appropriate response
            e.printStackTrace();
            return "Error generating signed URL";
        }
    }
}