package com.example.RestApiFramwordV1.respository;
import com.example.RestApiFramwordV1.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {

}
