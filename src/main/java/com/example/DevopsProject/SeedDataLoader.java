package com.example.DevopsProject;

import com.example.DevopsProject.model.Transaction;
import com.example.DevopsProject.repository.TransactionRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class SeedDataLoader implements ApplicationRunner {
    private final TransactionRepository transactionRepository;

    private LocalDateTime timestamp;

    public SeedDataLoader(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        this.timestamp = LocalDateTime.now();
        Transaction transaction = new Transaction();
        String logMessage = "[" + LocalDateTime.now().toString() + "] Server started";
        transaction.setContent(logMessage);
        transactionRepository.save(transaction);
    }
}