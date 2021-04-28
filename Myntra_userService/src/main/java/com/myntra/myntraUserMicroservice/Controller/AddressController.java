package com.myntra.myntraUserMicroservice.Controller;

import com.myntra.myntraUserMicroservice.Entity.Address;
import com.myntra.myntraUserMicroservice.Entity.User;
import com.myntra.myntraUserMicroservice.Service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AddressController {
    @Autowired
    AddressService adderessService;
    @GetMapping("/address/{id}")
    public List<Address> getAllAddress(@PathVariable("id") Long id){
        return adderessService.getAllAddress(id);
    }
    @PostMapping("/address")
    public Address addAddress(@RequestBody Address address){
        return adderessService.addAddress( address);
    }

    @PostMapping("/updateAddress")
    public Address updateAddress(@RequestBody Address address){
        return adderessService.updateAddress(address);
    }





}
