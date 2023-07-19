package com.example.JakartaStudyProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JakartaStudyProjectApplication {

    public static void main(String[] args) {
        //test
        SpringApplication.run(JakartaStudyProjectApplication.class, args);
//        PGDataManager pgDataManager = new PGDataManager();
//
//        try (Connection conn = pgDataManager.connectionWithPG();) {
//            pgDataManager.getAllCustomer(conn, true);
//            pgDataManager.addANewCustomer(conn, "Firstname_Test", "Lastname_Test");
//            pgDataManager.getAllCustomer(conn, false);
//            System.out.println(pgDataManager.getCountOfTable(conn, "customers"));
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }

}
