package com.meta.instagram.user;

import com.meta.instagram.user.dto.UserProfileResponse;
import com.meta.instagram.user.dto.UserRegisterRequest;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserRepo userRepo;
    public UserService(UserRepo userRepo){
        this.userRepo = userRepo;
    }

    public void add(UserRegisterRequest userRegisterRequest){
        User user = new User(userRegisterRequest.userName(),
                userRegisterRequest.userPassword(),
                0L,
                0L,
                userRegisterRequest.bio()
        );
        userRepo.save(user);
    }

    public User get(long id){
        return userRepo.getUserByUserId(id);
    }

    public UserProfileResponse getUserProfile(Long id){
        User user = userRepo.findById(id).orElse(null);
        return new UserProfileResponse(
                user.getUserName(),
                user.getBio(),
                user.getFollowingCount(),
                user.getFollowersCount()
        );
    }

    public List<UserProfileResponse> getAll() {
        return userRepo.findAll().stream().
                map(u -> new UserProfileResponse(
                        u.getUserName(),
                        u.getBio(),
                        u.getFollowingCount(),
                        u.getFollowersCount()
                ))
                .toList();
    }
}
