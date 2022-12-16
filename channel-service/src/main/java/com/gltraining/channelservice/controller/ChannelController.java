package com.gltraining.channelservice.controller;

import com.gltraining.channelservice.dto.ChangeName;
import com.gltraining.channelservice.dto.ChannelDetails;
import com.gltraining.channelservice.dto.CreateChannel;
import com.gltraining.channelservice.service.IChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/channel")
public class ChannelController {
    @Autowired
    private IChannelService iChannelService;
    @PostMapping("/add")
    public ChannelDetails addChannel(@RequestBody CreateChannel requestDto){
        return iChannelService.createChannel(requestDto);
    }
    @PutMapping("/change/name")
    public ChannelDetails changeName(@RequestBody ChangeName requestDTO) throws Exception {
       return iChannelService.changeName(requestDTO);
    }
}
