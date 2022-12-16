package com.gltraining.channelservice.repository;

import com.gltraining.channelservice.entity.MediaChannel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChannelRepository extends JpaRepository<MediaChannel, Long> {
}
