package com.awesome.customer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/customers")
@Slf4j
public record CustomerController(CustomerService customerService) {

    @PostMapping("/add")
    public void registerCustomer(@RequestBody CustomerRegistration request){
        log.info("new customer registration of {}" , request);

        customerService.register(request);
    }
    @GetMapping("/")
    public String add(){
        return "hello user ";
    }
}
