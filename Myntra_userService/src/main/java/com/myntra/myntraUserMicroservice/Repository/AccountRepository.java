package com.myntra.myntraUserMicroservice.Repository;

import com.myntra.myntraUserMicroservice.Entity.User;
import com.myntra.myntraUserMicroservice.Entity.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<UserAccount,Long> {

}
