package com.meta.instagram.user;

import com.meta.instagram.exception.UserException;
import com.meta.instagram.user.dto.UserProfileResponse;
import com.meta.instagram.user.dto.UserRegisterRequest;
import com.meta.instagram.user.exception.UserNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepo userRepo;
    public UserService(UserRepo userRepo){
        this.userRepo = userRepo;
    }

    public void add(UserRegisterRequest userRegisterRequest){
        //check if username already exist
        boolean isAnyOne = userRepo.existsByUserName(userRegisterRequest.userName());
        if(isAnyOne){
            throw new UserException("Username already exists with name : "+userRegisterRequest.userName());
        }

        User user = new User(
                userRegisterRequest.userName(),
                userRegisterRequest.userPassword(),
                0L,
                0L,
                userRegisterRequest.bio()
        );

        //add user
        userRepo.save(user);
    }

    public UserProfileResponse get(Long id){
        User user = userRepo.findByUserId(id).orElseThrow(
                () -> new UserNotFoundException("No user exist with id : "+id)
        );
        // if bio is empty
        return new UserProfileResponse(
                user.getUserId(),
                user.getUserName(),
                (user.getBio().isEmpty()) ? "" : user.getBio(),//checks if user left field empty
                user.getFollowingCount(),
                user.getFollowersCount()
        );
    }

    public List<UserProfileResponse> getAll() {
        return userRepo.findAll().stream().
                map(u -> new UserProfileResponse(
                        u.getUserId(),
                        u.getUserName(),
                        u.getBio(),
                        u.getFollowingCount(),
                        u.getFollowersCount()
                ))
                .toList();
    }

    //method for reel
    public User getUserByUsername(String userName){
        return userRepo.findByUserName(userName).orElseThrow( //orElse only work on Optional
                () -> new UserException("No user found with name "+ userName));
    }
}
