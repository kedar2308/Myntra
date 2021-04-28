package com.myntra.myntraUserMicroservice.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ManyToAny;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Address {
      @Id
     Long addressId;
     Long pincode;
     String address;
     String locality;
     String type_of_address;
     @ManyToOne
     @JsonBackReference
     User userAddress;

     public void setUser(User user){
          userAddress=user;
     }
}
