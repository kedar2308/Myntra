package com.myntra.myntraUserMicroservice.Service;

import com.myntra.myntraUserMicroservice.Entity.Address;
import com.myntra.myntraUserMicroservice.Entity.User;
import com.myntra.myntraUserMicroservice.Entity.UserAccount;
import com.myntra.myntraUserMicroservice.Repository.AccountRepository;
import com.myntra.myntraUserMicroservice.Repository.AddressRepository;
import com.myntra.myntraUserMicroservice.Repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class Userservice{
    @Autowired
    UserRepository userRepository;
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    AddressRepository addressRepository;
    @Autowired
    ModelMapper modelMapper;
    public User getUser(Long id) {
        UserDto udto= new UserDto();
        User user=userRepository.findById(id).get();
        modelMapper.map(user,udto);
     return udto;
    }


    public User addGivenUser(User user) {
        return userRepository.save(user);
    }


    public User assignAccount(Long id, UserAccount userAccount) {
        User user=userRepository.findById(id).get();
        user.addAccount(userAccount);
        userAccount.setUser(user);
        accountRepository.save(userAccount);
        return user;

    }

    @Transactional
    public User assignAddress(Long id, List<Address> address) {
        User user=userRepository.findById(id).get();

        for(Address address1: address){
            user.setAddress(address1);
            address1.setUser(user);
            addressRepository.save(address1);

        }
        return user;
    }

    public User updateUser(User user) {
        User user1 = userRepository.findById(user.getUserId()).get();
        user1.setUserName(user.getUserName());
        userRepository.save(user1);
        return user1;
    }

    public String deleteUser(Long userId) {
        // 1. Fetch the Object
        User st = userRepository.findById(userId).get();

        try {
            userRepository.delete(st);
            return "Successfully Deleted ";
        }
        catch (Exception ex){
            return "Deletion Failed";
        }

    }
}
