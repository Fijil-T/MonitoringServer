package com.example.DevopsProject;

import com.example.DevopsProject.model.Transaction;
import com.example.DevopsProject.repository.TransactionRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.sql.Time;

@SpringBootApplication
public class DevopsProjectApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(DevopsProjectApplication.class, args);
		TransactionRepository transactionRepository = context.getBean(TransactionRepository.class);
	}

}
