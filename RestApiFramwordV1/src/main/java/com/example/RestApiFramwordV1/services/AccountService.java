package com.example.RestApiFramwordV1.services;
import com.example.RestApiFramwordV1.models.Account;
import com.example.RestApiFramwordV1.respository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.RestApiFramwordV1.services.Interface.IAccountService;

import java.util.List;
import java.util.Optional;

@Service @RequiredArgsConstructor
public class AccountService implements IAccountService {
    private final AccountRepository accountRepository;



    @Override
    public List<Account> GetListAccount() {

        return accountRepository.findAll();
    }

    @Override
    public Optional<Account> GetListAccountById(long id) {
        return  accountRepository.findById(id);
    }
}
