package com.awesome.customer;

import org.springframework.stereotype.Service;

@Service
public record CustomerService( CustomerRepo customerRepo) {
    public void register(CustomerRegistration request) {
        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();
        // todos
        customerRepo.save(customer);
    }
}
