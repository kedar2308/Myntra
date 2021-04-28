package com.myntra.myntraUserMicroservice.Controller;

import com.myntra.myntraUserMicroservice.Entity.UserAccount;
import com.myntra.myntraUserMicroservice.Entity.UserProfile;
import com.myntra.myntraUserMicroservice.Service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AccountController {
    @Autowired
    AccountService accountService;

    @GetMapping("/account/{id}")

    public UserAccount getAccount(@PathVariable("id") Long id){
        return accountService.getAccount(id);
    }

    @PostMapping("/account")
    public UserAccount addAccount(@RequestBody UserAccount account){
        return accountService.addAccount(account);
    }


    @PostMapping("/assign/{id}/profile")
    public UserAccount assignProfile(@PathVariable("id") Long id, @RequestBody UserProfile userProfile){
        return accountService.assignProfile(id, userProfile);
    }

}
