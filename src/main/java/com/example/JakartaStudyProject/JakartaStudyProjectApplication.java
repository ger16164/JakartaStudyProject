package com.example.JakartaStudyProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;

@SpringBootApplication
public class JakartaStudyProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(JakartaStudyProjectApplication.class, args);
		PGDataManager pgDataManager = new PGDataManager();

		Connection conn = pgDataManager.connectionWithPG();
		pgDataManager.getAllCustomer(conn);
	}

}
