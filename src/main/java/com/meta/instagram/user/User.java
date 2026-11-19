package com.meta.instagram.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Data //for getters setters and hover for more info
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String userName;
    private String userPassword;
    private Long followersCount;
    private Long followingCount;
    private String bio;

    @CreationTimestamp  //Automatically sets the current date/time when saved
    private Date createdAt;

    public User(String userName, String userPassword, Long followersCount, Long followingCount, String bio) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.followersCount = followersCount;
        this.followingCount = followingCount;
        this.bio = bio;
    }
}