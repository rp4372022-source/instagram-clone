package com.meta.instagram.reel;

import com.meta.instagram.reel.dto.AddNewReelRequest;
import com.meta.instagram.user.User;
import com.meta.instagram.user.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReelService {
    private final ReelRepo reelRepo;
    private final UserService userService;

    ReelService(ReelRepo reelRepo,UserService userService){
        this.reelRepo = reelRepo;
        this.userService = userService;
    }

    //CRUD
    public void addNewReel(AddNewReelRequest newReelRequest){
        //preparing user for adding in reel
        User user = userService.getReferenceByUsername(newReelRequest.userName());

        //creating and saving reel
        Reel reel = new Reel(
                user,
                newReelRequest.caption(),
                "no-url",
                0L
        );
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

    public List<Reel> getAllReels() {
        return reelRepo.findAll();
    }
}
