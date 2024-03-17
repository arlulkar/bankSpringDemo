package com.example.bank.service.impl;

import com.example.bank.dto.AccountDto;
import com.example.bank.entiry.Account;
import com.example.bank.mapper.AccountMapper;
import com.example.bank.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.bank.repository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        Account account = AccountMapper.mapToAccount(accountDto);
        Account saved = accountRepository.save(account);
        return AccountMapper.mapToAccountDto(saved);
    }

    public AccountDto getAccountById(int id){
        Account account = accountRepository.getReferenceById(id);
        return AccountMapper.mapToAccountDto(account);
    }

    @Override
    public AccountDto depositeAmount(int id, Double amount) {
        Account account = accountRepository.getReferenceById(id);
        account.setBalance( account.getBalance()+amount );
        return AccountMapper.mapToAccountDto(account);
    }
}
