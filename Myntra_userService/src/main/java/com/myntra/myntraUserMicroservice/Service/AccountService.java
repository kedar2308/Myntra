package com.myntra.myntraUserMicroservice.Service;

import com.myntra.myntraUserMicroservice.Entity.User;
import com.myntra.myntraUserMicroservice.Entity.UserAccount;
//import com.myntra.myntraUserMicroservice.Entity.UserProfile;
import com.myntra.myntraUserMicroservice.Entity.UserProfile;
import com.myntra.myntraUserMicroservice.Repository.AccountRepository;
//import com.myntra.myntraUserMicroservice.Repository.ProfileRepository;
import com.myntra.myntraUserMicroservice.Repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AccountService{
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    ProfileRepository profileRepository;

    public UserAccount getAccount(Long id) {
         return accountRepository.findById(id).get();
    }


    public UserAccount addAccount(UserAccount account) {
        return accountRepository.save(account);

    }

    public UserAccount assignProfile(Long id, UserProfile userProfile) {
        UserAccount useraccount=accountRepository.findById(id).get();
        useraccount.setProfile(userProfile);
        userProfile.setAccount(useraccount);
        profileRepository.save(userProfile);
        return useraccount;
    }


}
