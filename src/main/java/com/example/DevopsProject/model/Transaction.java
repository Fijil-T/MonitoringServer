package com.example.DevopsProject.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    // Constructors, getters, and setters

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

}
