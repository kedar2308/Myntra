package com.myntra.myntraUserMicroservice.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class User {
    @Id
    Long userId;
    String userName;

    @OneToOne(mappedBy = "user")
    @JsonManagedReference
    private UserAccount account;
    public void addAccount(UserAccount userAccount) {
     account=userAccount;
    }
    @OneToMany(mappedBy = "userAddress", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JsonManagedReference
    List<Address> addressList=new ArrayList<>();
    public void setAddress(Address address){
         addressList.add(address);
    }

}
