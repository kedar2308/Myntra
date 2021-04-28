package com.myntra.myntraUserMicroservice.Service;

import com.myntra.myntraUserMicroservice.Entity.Address;
import com.myntra.myntraUserMicroservice.Entity.User;
import com.myntra.myntraUserMicroservice.Repository.AddressRepository;
import com.myntra.myntraUserMicroservice.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class AddressService {

    @Autowired
    AddressRepository addressRepository;
    @Autowired
    UserRepository userRepository;

    public List<Address> getAllAddress(Long id) {
        return (List<Address>) addressRepository.findById(id).get();
    }

    public Address addAddress(Address address) {
        return addressRepository.save(address);
    }

    public Address updateAddress(Address address) {
        Address address1=addressRepository.findById(address.getAddressId()).get();
        address1.setPincode(address.getPincode());
        address1.setAddress(address.getAddress());
        address1.setLocality(address.getLocality());
        address1.setType_of_address(address.getType_of_address());
        addressRepository.save(address1);
        return address1;
    }
}
