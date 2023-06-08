package com.eniskeskin.weatherforecastapp.dao;

import com.eniskeskin.weatherforecastapp.entity.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// UserRepository.java
@Repository
public interface UserRepository extends JpaRepository<UserProfile, Long> {
    //User findByUsername(String username);
}

