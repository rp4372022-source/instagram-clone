package com.meta.instagram.reel;

import org.springframework.stereotype.Service;

@Service
public class ReelService {
    private final ReelRepo reelRepo;

    ReelService(ReelRepo reelRepo){
        this.reelRepo = reelRepo;
    }

    //CRUD
    public void addReel(Reel reel){
        reelRepo.save(reel);
    }
    public void updateReel(Reel reel){
        reelRepo.save(reel);//same cuz it checks anyway
    }
    public Reel getReel(long id){
        return reelRepo.findByReelId(id);
    }
    public Reel deleteReel(long id){
        return reelRepo.deleteByReelId(id);
    }
}
