package com.meta.instagram.reel;

import com.meta.instagram.user.User;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name= "reels")
public class Reel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reelId;
    @ManyToOne(fetch = FetchType.LAZY)//foreign key to user table
    @JoinColumn(name="user_id",nullable = false)
    private User user; //needed cuz that's how JPA works
    private String reelCaption;
    private String reelURL;
    private Long likesCount;

    public Reel(User user, String reelCaption, String reelURL, Long likesCount) {
        this.user = user;
        this.reelCaption = reelCaption;
        this.reelURL = reelURL;
        this.likesCount = likesCount;
    }
}
