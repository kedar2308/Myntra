package com.myntra.myntraUserMicroservice.Controller;

import com.myntra.myntraUserMicroservice.Dto.Courses;
import com.myntra.myntraUserMicroservice.Entity.Address;
import com.myntra.myntraUserMicroservice.Entity.User;
import com.myntra.myntraUserMicroservice.Entity.UserAccount;
import com.myntra.myntraUserMicroservice.Service.Userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class UserController{
    @Autowired
  Userservice userservice;
    @Autowired
    RestTemplate restTemplate;

        @GetMapping("/courses")
        public List<Courses> getCourses(){

            List<Courses> courses = restTemplate.getForObject("http://localhost:8050/courses",List.class);
            return courses;
        }

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable("id") Long id) {
        return userservice.getUser(id);
    }

    @PostMapping("/user")
    public User addUser(@RequestBody User user){
        return userservice.addGivenUser(user);
    }


    @PostMapping("/assign/{id}/account")
    public User assignAccount(@PathVariable("id") Long id, @RequestBody UserAccount userAccount){
        return userservice.assignAccount(id, userAccount);
    }


    @PostMapping("/assign/{id}/address")
    public User assignAddress(@PathVariable("id") Long id, @RequestBody List<Address> address){
        return userservice.assignAddress(id, address);
    }
    @PostMapping("/userUpdate/details")
    public User updateUser(@RequestBody User user){
        return userservice.updateUser(user);
    }


    @DeleteMapping("/user/{id}")
    public String deleteUser(@PathVariable("id") Long userId){
        String msg = userservice.deleteUser(userId);
        return msg;
    }
}
