package com.myntra.myntraUserMicroservice.Entity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table( uniqueConstraints = { @UniqueConstraint(columnNames = {"user_account_id"})})
public class UserAccount {
    @Id
    Long AccountId;
  @OneToOne
  @JsonBackReference
  @JoinColumn(name="user_account_id")
    private User user;
    public void setUser(User user) {
        this.user=user;
    }

    @OneToOne(mappedBy="userAccount")
     @JsonManagedReference
    UserProfile profile;
    public void setProfile(UserProfile userProfile) {
        profile=userProfile;
    }


}
