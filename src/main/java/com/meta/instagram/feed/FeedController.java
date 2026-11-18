package com.meta.instagram.feed;

import com.meta.instagram.reel.Reel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/feed")
public class FeedController {

    private FeedService feedService;

    FeedController(FeedService feedService){
        this.feedService = feedService;
    }

    @GetMapping("/getall")
    public ResponseEntity<List<Reel>> getReels(){
        List<Reel> reelList = feedService.generateFeed();
        return new ResponseEntity<>(reelList, HttpStatus.OK);
    }
}
