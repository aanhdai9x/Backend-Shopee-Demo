package com.cmc.demoshopee.repository;

import com.cmc.demoshopee.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    public User findByUsername(String username);

    Optional<User> findByUsernameAndPassword(String username, String password);

}
