package com.example.beefsenseapi.dtos;

public class PredictionDTO {
    private String category;
    private float confidence;

    public PredictionDTO(String category, float confidence) {
        this.category = category;
        this.confidence = confidence;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public float getConfidence() {
        return confidence;
    }

    public void setConfidence(float confidence) {
        this.confidence = confidence;
    }
}