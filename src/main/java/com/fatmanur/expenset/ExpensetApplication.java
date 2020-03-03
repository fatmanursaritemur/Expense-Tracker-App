package com.fatmanur.expenset;


import org.h2.tools.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.SQLException;

@SpringBootApplication
public class ExpensetApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExpensetApplication.class, args);
	}

}
