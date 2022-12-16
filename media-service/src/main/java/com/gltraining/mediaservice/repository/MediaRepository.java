package com.gltraining.mediaservice.repository;

import com.gltraining.mediaservice.entity.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MediaRepository extends JpaRepository<Video, Long> {
}
