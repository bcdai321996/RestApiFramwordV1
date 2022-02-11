package com.example.RestApiFramwordV1.respository;
import com.example.RestApiFramwordV1.models.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
    @Override
    Page<Account> findAll(Pageable pageable);
    Page<Account> findByUserNameContaining(String user_name,Pageable pageable);
}
