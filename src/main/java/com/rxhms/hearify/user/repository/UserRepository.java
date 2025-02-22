package com.rxhms.hearify.user.repository;

import com.rxhms.hearify.user.business.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    boolean existsByEmail(String email);
    Optional<User> findByUsernameAndPasswordHash(String username, String passwordHash);
}

