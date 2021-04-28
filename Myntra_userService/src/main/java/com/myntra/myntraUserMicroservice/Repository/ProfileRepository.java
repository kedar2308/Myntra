package com.myntra.myntraUserMicroservice.Repository;

import com.myntra.myntraUserMicroservice.Entity.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends JpaRepository<UserProfile,Long> {

}
