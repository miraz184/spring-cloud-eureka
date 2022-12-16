package com.gltraining.channelservice.util;

import com.gltraining.channelservice.dto.ChannelDetails;
import com.gltraining.channelservice.entity.MediaChannel;
import org.springframework.stereotype.Component;

@Component
public class ChannelUtil {

    public ChannelDetails toChannelDetails(MediaChannel mediaChannel) {
        ChannelDetails desired = new ChannelDetails();
        desired.setId(mediaChannel.getId());
        desired.setName(mediaChannel.getName());
        desired.setCreatedBy(mediaChannel.getCreatedBy());
        return desired;
    }

}
