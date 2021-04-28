package com.myntra.myntraUserMicroservice.Controller;

import com.myntra.myntraUserMicroservice.Entity.User;
import com.myntra.myntraUserMicroservice.Entity.UserAccount;
import com.myntra.myntraUserMicroservice.Entity.UserProfile;
import com.myntra.myntraUserMicroservice.Service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProfileController {

     @Autowired
     ProfileService profileService;

    @GetMapping("/profile/{id}")
    public UserProfile getProfile(@PathVariable("id") Long id){
        return profileService.getProfile(id);
    }


    @PostMapping("/profile")
    public UserProfile addProfile(@RequestBody UserProfile profile){
        return profileService.addProfile(profile);
    }

    @PostMapping("/updateProfile")
    public UserProfile updateProfile(@RequestBody UserProfile profile){
        return profileService.updateProfile(profile);
    }

}
