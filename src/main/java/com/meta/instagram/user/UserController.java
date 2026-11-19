package com.meta.instagram.user;

import com.meta.instagram.user.dto.UserProfileResponse;
import com.meta.instagram.user.dto.UserRegisterRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/add")
    public ResponseEntity<HttpStatus> addUser(@RequestBody UserRegisterRequest userRegisterRequest){
        System.out.println(userRegisterRequest.toString());
        userService.add(userRegisterRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<UserProfileResponse> getUserProfileResponse(@PathVariable long id){
        return new ResponseEntity<>(userService.getUserProfile(id), HttpStatus.OK);
    }

    @GetMapping("/getallusers")
    public ResponseEntity<List<UserProfileResponse>> getAllUserProfiles(){
        return new ResponseEntity<>(userService.getAll(),HttpStatus.OK);
    }
}
