package com.gltraining.mediaservice.controller;

import com.gltraining.mediaservice.dto.ChangeName;
import com.gltraining.mediaservice.dto.MediaDetails;
import com.gltraining.mediaservice.dto.UploadRequest;
import com.gltraining.mediaservice.service.IMediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/media")
public class MediaController {
    @Autowired
    private IMediaService mediaService;

    @PostMapping("/upload")
    public MediaDetails upLoadMedia(@RequestBody UploadRequest requestDto) throws Exception {
        return mediaService.upload(requestDto);
    }

    @PutMapping("/changeName")
    public MediaDetails changeName(@Valid @RequestBody ChangeName changeName) throws Exception {
        return mediaService.changeName(changeName);
    }

    @GetMapping("/allMedia/{channelId}")
    public List<MediaDetails> findMediasForChannel(@Valid @PathVariable Long channelId) throws Exception {
        return mediaService.findMediasByChannel(channelId);
    }

    @DeleteMapping("/removeMedia/{mediaId}")
    public Boolean removeMedia(@Valid @PathVariable Long mediaId) throws Exception {
        return mediaService.removeMedia(mediaId);
    }
}
