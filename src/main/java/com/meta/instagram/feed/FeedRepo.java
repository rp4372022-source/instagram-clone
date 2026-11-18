package com.meta.instagram.feed;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedRepo extends JpaRepository<Feed, Long> {

}
