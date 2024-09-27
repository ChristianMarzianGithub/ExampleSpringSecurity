package com.example.demo.controller;

import com.example.demo.model.CustomerBE;
import com.example.demo.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerRepository customerRepository;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/createNewCustomer")
    public ResponseEntity<String> createNewCustomer(@RequestBody CustomerBE customerBE){
        try{
            customerBE.setPassword(passwordEncoder.encode(customerBE.getPassword()));
            CustomerBE savedCustomerBE = customerRepository.save(customerBE);

            if(savedCustomerBE.getId() > 0){
                return ResponseEntity.status(HttpStatus.CREATED)
                        .body("Given user details are successfully registered");
            }else{
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body("User registration failed");
            }

        }catch(Exception exception ){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An exception while Creating a new Customer occurred: " + exception.getMessage());
        }
    }

    @GetMapping("/changePassword")
    public String changePassword(String oldPassword, String newPassword){
        return "asdf";
    }

    @PostMapping("/changeEmail")
    public void changeEmail(String oldEmail, String newEmail, String password){

    }
}