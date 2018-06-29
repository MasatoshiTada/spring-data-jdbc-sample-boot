package com.example;

import com.example.entity.Customer;
import com.example.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class SpringDataJdbcSampleBootApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringDataJdbcSampleBootApplication.class, args);
    }

    @Autowired
    CustomerRepository customerRepository;
    
    @Override
    public void run(String... args) throws Exception {
        List<Customer> customers = customerRepository.findByCustomerName("%o%");
        for (Customer customer : customers) {
            System.out.println(customer.getId() + ":" + customer.getName());
        }
    }
}
