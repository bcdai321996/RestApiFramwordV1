package com.example.RestApiFramwordV1.controller;
import com.example.RestApiFramwordV1.models.Account;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.RestApiFramwordV1.services.Interface.IAccountService;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor

public class AccountController {

   private final IAccountService accountService;

    @GetMapping(value ="/accounts")
    public ResponseEntity<List<Account>> GetAccount(){
        return ResponseEntity.ok().body(accountService.GetListAccount());
    }
    @GetMapping(value ="/accounts/{id}")
    public ResponseEntity<Optional<Account>> GetAccountById(@PathVariable("id") long id){
        return new ResponseEntity<>(accountService.GetListAccountById(id), HttpStatus.OK);
    }
    @PostMapping(value ="/accounts")
    public ResponseEntity<Account> GetAccountById(@RequestBody Account account){
        return new ResponseEntity<>(accountService.InsertAccount(account), HttpStatus.CREATED);
    }
}
