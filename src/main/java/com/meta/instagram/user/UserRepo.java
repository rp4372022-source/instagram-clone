package com.meta.instagram.user;

import com.meta.instagram.user.dto.UserProfileResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    UserProfileResponse findByUserName(String name);

    User getUserByUserId(long id);
}
