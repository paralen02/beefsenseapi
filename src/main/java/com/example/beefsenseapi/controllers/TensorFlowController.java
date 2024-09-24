package com.example.beefsenseapi.controllers;

import com.example.beefsenseapi.serviceimplements.TensorFlowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api")
public class TensorFlowController {
    @Autowired
    private TensorFlowService tensorFlowService;

    @PostMapping("/predict")
    public String predict(@RequestParam("file") MultipartFile file) {
        try {
            return tensorFlowService.predict(file);
        } catch (IOException e) {
            throw new RuntimeException("Failed to process the image", e);
        }
    }
}