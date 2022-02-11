package com.example.RestApiFramwordV1.respository;
import com.example.RestApiFramwordV1.models.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Long> {
    @Override
    Page<Account> findAll(Pageable pageable);
    @Query("SELECT a FROM Account a WHERE a.status = 0 AND (TRIM(a.email) = TRIM(:email)" +
            " OR TRIM(a.userName)= TRIM(:userName) OR TRIM(a.fullName)= TRIM(:fullName))")
    List<Account> findByUserNameOrEmailAndStatus(String userName, String email, String fullName);

    @Query("SELECT a FROM Account a WHERE a.status = 0 AND (TRIM(a.email) = TRIM(:email))")
    List<Account> findAbc(String email);

//    @Query("SELECT a FROM Account a WHERE a.status = 0 AND (TRIM(a.email) = TRIM(:email)" +
//            " OR TRIM(a.fullName)= TRIM(:fullName))")
    @Query("SELECT a FROM Account a WHERE a.status = 0 AND (TRIM(a.userName) = TRIM(:userName)" +
        " OR TRIM(a.email)= TRIM(:email) OR TRIM(a.fullName)= TRIM(:fullName))")
    Page<Account> findXyz(String userName,String email, String fullName, Pageable pageable);
}
