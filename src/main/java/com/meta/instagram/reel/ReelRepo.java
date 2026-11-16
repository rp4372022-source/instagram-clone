package com.meta.instagram.reel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReelRepo extends JpaRepository<Reel, Long> {
    Reel findByReelId(long id);

    Reel deleteByReelId(long id);
}
