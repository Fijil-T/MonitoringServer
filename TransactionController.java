package com.DevopsCourse.DevOpsProject;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionController {

    @PostMapping("/transactions")
    public String createTransaction(@RequestBody Transaction transaction) {
        return "Transaction created successfully";
    }
}