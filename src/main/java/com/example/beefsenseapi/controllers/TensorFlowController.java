package com.example.beefsenseapi.controllers;

import com.example.beefsenseapi.dtos.PredictionDTO;
import com.example.beefsenseapi.serviceimplements.TensorFlowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class TensorFlowController {
    @Autowired
    private TensorFlowService tensorFlowService;

    @PostMapping("/predict")
    public List<PredictionDTO> predict(@RequestParam("file") MultipartFile file) {
        try {
            return tensorFlowService.predict(file);
        } catch (IOException e) {
            throw new RuntimeException("Failed to process the image", e);
        }
    }
}