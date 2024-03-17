package com.example.bank.service;

import com.example.bank.dto.AccountDto;

public interface AccountService {
    AccountDto createAccount(AccountDto accountDto);
    AccountDto getAccountById(int id);

    AccountDto depositeAmount(int id, Double amount);

}
