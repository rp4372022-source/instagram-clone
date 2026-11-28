package com.meta.instagram.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    Optional<User> findByUserName(String name); //making optional allows orElseThrow in service and prevents null pointer exception

    Optional<User> findByUserId(long id);

    boolean existsByUserName(String userName);
}
