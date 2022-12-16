package com.gltraining.mediaservice.service;

import com.gltraining.mediaservice.dto.ChangeName;
import com.gltraining.mediaservice.dto.MediaDetails;
import com.gltraining.mediaservice.dto.UploadRequest;
import com.gltraining.mediaservice.exception.InvalidArgumentException;
import com.gltraining.mediaservice.exception.MediaNotFoundException;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@Validated
public interface IMediaService {
    MediaDetails upload(@Valid UploadRequest requestDTO) throws InvalidArgumentException;

    MediaDetails changeName(@Valid ChangeName requestDTO) throws MediaNotFoundException;

    List<MediaDetails> findMediasByChannel(@Min(1) long channelID) throws MediaNotFoundException;

    Boolean removeMedia(@Min(1) long mediaId) throws MediaNotFoundException;
}
