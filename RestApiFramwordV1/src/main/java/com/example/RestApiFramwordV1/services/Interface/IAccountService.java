package com.example.RestApiFramwordV1.services.Interface;
import com.example.RestApiFramwordV1.models.Account;

import java.util.List;
import java.util.Optional;

public interface IAccountService {
    List<Account> GetListAccount();
    Optional<Account> GetListAccountById(long id);
}
