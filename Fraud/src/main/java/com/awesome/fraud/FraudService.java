package com.awesome.fraud;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service @AllArgsConstructor
public class FraudService {

    private final FraudRepo fraudRepo ;


    public boolean isFraudCustomer(Integer customerId){

        fraudRepo.save(

                FraudCheckHistory.builder()
                        .customerId(customerId)
                        .isFraud(false)
                        .createdAt(LocalDateTime.now())
                        .build()

        );
        return false ;
    }
}
