package com.myntra.myntraUserMicroservice.Service;

import com.myntra.myntraUserMicroservice.Entity.UserProfile;
import com.myntra.myntraUserMicroservice.Repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {
    @Autowired
    ProfileRepository profileRepository;

    public UserProfile getProfile(Long id) {
        return profileRepository.findById(id).get();
    }

    public UserProfile addProfile(UserProfile profile) {
        return profileRepository.save(profile);
    }

    String fullName;
    Long mobileNo;
    String emailId;
    String gender;
    String location;
    String hintName;
    Long AltMobileNo;


    public UserProfile updateProfile(UserProfile profile) {
        UserProfile profile1=profileRepository.findById(profile.getProfileId()).get();
         profile1.setFullName(profile.getFullName());
         profile1.setMobileNo(profile.getMobileNo());
         profile1.setEmailId(profile.getEmailId());
         profile1.setLocation(profile.getLocation());
         profileRepository.save(profile1);

        return profile1;
    }
}
