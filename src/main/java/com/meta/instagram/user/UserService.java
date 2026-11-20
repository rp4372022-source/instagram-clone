package com.meta.instagram.user;

import com.meta.instagram.exception.UserException;
import com.meta.instagram.user.dto.UserProfileResponse;
import com.meta.instagram.user.dto.UserRegisterRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepo userRepo;
    public UserService(UserRepo userRepo){
        this.userRepo = userRepo;
    }

    public void add(UserRegisterRequest userRegisterRequest){
        User user = new User(
                userRegisterRequest.userName(),
                userRegisterRequest.userPassword(),
                0L,
                0L,
                userRegisterRequest.bio()
        );

        //check if username already exist
        boolean isAnyOne = userRepo.existsByUserName(user.getUserName());
        if(isAnyOne){
            throw new UserException("Username already exists with name : "+user.getUserName());
        }

        //add user
        userRepo.save(user);
    }

    public User get(Long id){
        validate(id);
        return userRepo.getUserByUserId(id);
    }

    public UserProfileResponse getUserProfile(Long id){
        validate(id);
        User user = userRepo.findById(id).orElse(null);

        if(user == null){
            throw new UserException("No user found with id: "+id);
        }

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

    //validation method to verify id
    private void validate(Long id){
        if(id == null){
            throw new UserException("Id cannot be null");
        }
        if(id < 0){
            throw new UserException("Id cannot be negative");
        }
    }
}
