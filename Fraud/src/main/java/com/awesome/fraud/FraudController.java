package com.awesome.fraud;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/fraud-check")
@AllArgsConstructor
public class FraudController {

    private final FraudService fraudService ;

    @GetMapping("/")
    public String fraudApp(){
        return "fraud app running" ;
    }

    @GetMapping("{customerId}")
    public FraudCheckResponse checkResponse(@PathVariable Integer customerId){

        return new FraudCheckResponse(fraudService.isFraudCustomer(customerId));
    }
}
