package com.gltraining.channelservice.service;

import com.gltraining.channelservice.dto.ChangeName;
import com.gltraining.channelservice.dto.ChannelDetails;
import com.gltraining.channelservice.dto.CreateChannel;
import com.gltraining.channelservice.exception.ChannelNotFoundException;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

@Validated
public interface IChannelService {
    ChannelDetails createChannel(@Valid CreateChannel createChannel);
    ChannelDetails changeName(@Valid ChangeName changeName) throws ChannelNotFoundException;
}
