package com.example.apigateway.service;

import com.example.apigateway.api.dto.RequestCustomerSignInDto;
import com.example.apigateway.api.dto.RequestCustomerSignUpDto;
import com.example.apigateway.api.dto.ResponseCustomerDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "customer-service", url = "${application.restUri}")
public interface CustomerService {

    @PostMapping(value = "/api/v1/auth/sign_in", consumes = "application/json")
    ResponseCustomerDto signIn(@RequestBody RequestCustomerSignInDto dto);

    @PostMapping(value = "/api/v1/auth/sign_up", consumes = "application/json")
    ResponseCustomerDto signUp(@RequestBody RequestCustomerSignUpDto dto);
}
