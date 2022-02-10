package com.example.RestApiFramwordV1.services;
import com.example.RestApiFramwordV1.models.Account;
import com.example.RestApiFramwordV1.respository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.RestApiFramwordV1.services.Interface.IAccountService;

import java.util.List;
@Service @RequiredArgsConstructor
public class AccountService implements IAccountService {
    private final AccountRepository accountRepository;



    @Override
    public List<Account> GetListAccount() {

        return accountRepository.findAll();
    }
}
