package com.meta.instagram.feed;

import com.meta.instagram.reel.Reel;
import com.meta.instagram.reel.ReelService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedService {

    private FeedRepo feedRepo;
    private ReelService reelService;

    FeedService(FeedRepo feedRepo, ReelService reelService){
        this.feedRepo = feedRepo;
        this.reelService = reelService;
    }

    public List<Reel> generateFeed(){
        return reelService.getAllReels();
    }
}
