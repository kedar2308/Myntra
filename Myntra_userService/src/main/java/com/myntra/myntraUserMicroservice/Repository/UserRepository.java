package com.myntra.myntraUserMicroservice.Repository;

import com.myntra.myntraUserMicroservice.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

}
