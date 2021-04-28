package com.myntra.myntraUserMicroservice.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class UserProfile {
        @Id
    Long profileId;
    String fullName;
    Long mobileNo;
    String emailId;
    String gender;
    String location;
    String hintName;
    Long AltMobileNo;

 @OneToOne
 @JsonBackReference
 @JoinColumn(name="profile_accountId")

 UserAccount userAccount;
    public void setAccount(UserAccount useraccount) {
        userAccount=useraccount;
    }




}
