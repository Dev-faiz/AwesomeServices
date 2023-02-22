package com.awesome.customer;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service @Slf4j
public record CustomerService(CustomerRepo customerRepo , RestTemplate restTemplate) {
    public void register(CustomerRegistration request) {
        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();
        // todos

        customerRepo.saveAndFlush(customer);
        log.info("customer {}" , customer);
        FraudCheckResponse checkResponse = restTemplate.getForObject(
                "http://localhost:8082/api/v1/fraud-check/{customerId}" ,
                FraudCheckResponse.class ,
                customer.getId()
        );
        log.info("outside restTemp");
        if(checkResponse.isFraud()) throw new   IllegalStateException("fraudster") ;

    }
}
