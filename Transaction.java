package com.DevopsCourse.DevOpsProject;

public class Transaction {

    private Long id;
    private String description;


    public Transaction(Long id, String description) {
        this.id = id;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }
}