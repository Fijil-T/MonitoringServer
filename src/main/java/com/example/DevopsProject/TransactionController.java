package com.example.DevopsProject;

import com.example.DevopsProject.model.Transaction;
import com.example.DevopsProject.repository.TransactionRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api")
public class TransactionController {
    private final ObjectMapper objectMapper;

    private final TransactionRepository transactionRepository;
    private LocalDateTime timestamp;

    public TransactionController(ObjectMapper objectMapper, TransactionRepository transactionRepository) {
        this.objectMapper = objectMapper;
        this.transactionRepository = transactionRepository;
    }

    @GetMapping("/transaction")
    public Transaction route1() {
        Transaction transaction = new Transaction();
        this.timestamp = LocalDateTime.now();
        transaction.setContent(timestamp + "A new transaction has been made");

        return transactionRepository.save(transaction);
    }

    @GetMapping("/logs")
    public String route2() throws JsonProcessingException {
        Transaction transaction = new Transaction();
        this.timestamp = LocalDateTime.now();
        transaction.setContent(timestamp + " User asked for all logs.");
        transactionRepository.save(transaction);
        List<Transaction> transactions = transactionRepository.findAll();

        return objectMapper.writeValueAsString(transactions);
    }
}