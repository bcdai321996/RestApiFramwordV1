package com.example.RestApiFramwordV1.services.Interface;
import com.example.RestApiFramwordV1.models.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IAccountService {
    Page<Account> GetListAccount(Pageable paging);
    Page<Account> findByUserNameOrEmailAndStatus(String user_name, String full_name,String email,Pageable pageable);
    Optional<Account> GetListAccountById(long id);
    Account InsertAccount(Account account);
}
