package com.example.bank.controller;

import com.example.bank.dto.AccountDto;
import com.example.bank.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/account")

public class AccountController{
    AccountService accountService;
    private Map<String, Double> request;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    ResponseEntity<AccountDto> createAccount(@RequestBody AccountDto accountDto){
        //accountService.createAccount(accountDto, HttpStatus.CREATED);
        return new ResponseEntity<>(accountService.createAccount(accountDto),HttpStatus.CREATED);

    }

    @GetMapping("/{id}")
    ResponseEntity<AccountDto> getAccountById(@PathVariable int id){
        return new ResponseEntity<>(accountService.getAccountById(id),HttpStatus.OK);
    }

    @PutMapping("/{id}")
    ResponseEntity<AccountDto> depositeAmount(@PathVariable int id,
                                              @RequestBody Map<String,Double> request){
        this.request = request;
        return new ResponseEntity<>(accountService.depositeAmount(id,request.get("Amount")),HttpStatus.OK);
    }
}
