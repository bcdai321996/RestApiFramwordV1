package com.example.RestApiFramwordV1.services;
import com.example.RestApiFramwordV1.models.Account;
import com.example.RestApiFramwordV1.respository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.example.RestApiFramwordV1.services.Interface.IAccountService;

import java.util.List;
import java.util.Optional;

@Service @RequiredArgsConstructor
public class AccountService implements IAccountService {
    private final AccountRepository accountRepository;


    @Override
    public Page<Account> GetListAccount(Pageable paging) {
        return accountRepository.findAll(paging);
    }

    @Override
    public Page<Account> findByUserNameOrEmailAndStatus(String userName,String fullName, String email,Pageable pageable) {
//        List<Account> rt =  accountRepository.findAbc(email);
        Page<Account> rt =  accountRepository.findXyz(userName, email, fullName, pageable);
//        Page<Account> rt =  accountRepository.findByUserNameOrEmailAndStatus(userName, fullName,email, pageable);

        return rt;
    }


    @Override
    public Optional<Account> GetListAccountById(long id) {
        return  accountRepository.findById(id);
    }

    @Override
    public Account InsertAccount(Account account) {
        return accountRepository.save(account);
    }
}
