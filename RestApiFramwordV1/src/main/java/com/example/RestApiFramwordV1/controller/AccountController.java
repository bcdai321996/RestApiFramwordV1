package com.example.RestApiFramwordV1.controller;
import com.example.RestApiFramwordV1.models.Account;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.RestApiFramwordV1.services.Interface.IAccountService;

import java.util.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor

public class AccountController {

   private final IAccountService accountService;

    @GetMapping(value ="/accounts")
    public ResponseEntity<Map<String, Object>> GetAccount(
            @RequestParam(required = false) String user_name,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size

    ){
        try{
            List<Account> listAccount = new ArrayList<Account>();
            Pageable paging = PageRequest.of(page, size);
            Page<Account> pageAccount;
            if(user_name == null){
                pageAccount = accountService.GetListAccount(paging);
            }
            else{
                pageAccount = accountService.findByUserNameContaining(user_name,paging);
            }
            listAccount = pageAccount.getContent();
            Map<String, Object> response = new HashMap<>();
            response.put("Accounts", listAccount);
            response.put("currentPage", pageAccount.getNumber());
            response.put("totalItems", pageAccount.getTotalElements());
            response.put("totalPages", pageAccount.getTotalPages());
            return new ResponseEntity<>(response,HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
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
