package com.example.JakartaStudyProject.Controller;

import com.example.JakartaStudyProject.Entities.Customer;
import com.example.JakartaStudyProject.Repository.CustomerRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/customers/findById/{id}")
    public Optional<Customer> getById(@PathVariable("id") Long id) {
        return customerRepository.findById(id);
    }

    @GetMapping("/customers")
    public List<Customer> getAllUsers() {
        return customerRepository.findAll();
    }

    @DeleteMapping("/customers/deleteById/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        customerRepository.deleteById(id);
    }

    @PostMapping("/customers/updateById/{id}/{firstname}")
    public void deleteById(@PathVariable("id") Long id, @PathVariable("firstname") String firstname) {
        Optional<Customer> optionalCustomer = customerRepository.findById(id);
        if (optionalCustomer.isPresent()) {
            Customer customer = optionalCustomer.get();
            customer.setFirstname(firstname);
            customerRepository.save(customer);
        }
    }

}