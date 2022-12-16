package com.gltraining.channelservice.service;

import com.gltraining.channelservice.dto.ChangeName;
import com.gltraining.channelservice.dto.ChannelDetails;
import com.gltraining.channelservice.dto.CreateChannel;
import com.gltraining.channelservice.entity.MediaChannel;
import com.gltraining.channelservice.exception.ChannelNotFoundException;
import com.gltraining.channelservice.repository.ChannelRepository;
import com.gltraining.channelservice.util.ChannelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class ChannelServiceImp implements IChannelService {
    private ChannelRepository channelRepository;
    private ChannelUtil channelUtil;

    public static final String CHANNEL_NOT_FOUND = "channel is not found";

    @Autowired
    public ChannelServiceImp(ChannelRepository channelRepository, ChannelUtil channelUtil) {
        this.channelRepository = channelRepository;
        this.channelUtil = channelUtil;
    }

    @Override
    @Transactional
    public ChannelDetails createChannel(CreateChannel createChannel) {
        MediaChannel mediaChannel = new MediaChannel();
        mediaChannel.setName(createChannel.getName());
        mediaChannel.setCreatedBy(createChannel.getCreatedBy());
        return channelUtil.toChannelDetails(channelRepository.save(mediaChannel));
    }

    @Override
    @Transactional
    public ChannelDetails changeName(ChangeName changeName) throws ChannelNotFoundException {
        Optional<MediaChannel> optional = channelRepository.findById(changeName.getId());
        if (optional.isPresent()) {
            MediaChannel mediaChannel = optional.get();
            mediaChannel.setName(changeName.getName());
            mediaChannel.setCreatedBy(mediaChannel.getCreatedBy());
            channelRepository.save(mediaChannel);
            return channelUtil.toChannelDetails(mediaChannel);
        } else {
            throw new ChannelNotFoundException(CHANNEL_NOT_FOUND);
        }
    }
}
