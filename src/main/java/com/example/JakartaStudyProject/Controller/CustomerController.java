package com.example.JakartaStudyProject.Controller;

import com.example.JakartaStudyProject.Entities.Customer;
import com.example.JakartaStudyProject.Repository.CustomerRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {
    private final CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping("/customers/findByFirstname/{firstname}")
    public List<Customer> getByFirstName(@PathVariable("firstname") String firstname) {
        return customerRepository.findByFirstname(firstname);
    }

    @GetMapping("/customers")
    public List<Customer> getAllUsers() {
        return customerRepository.findAll();
    }
}