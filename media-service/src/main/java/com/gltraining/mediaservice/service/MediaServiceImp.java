package com.gltraining.mediaservice.service;

import com.gltraining.mediaservice.dto.ChangeName;
import com.gltraining.mediaservice.dto.MediaDetails;
import com.gltraining.mediaservice.dto.UploadRequest;
import com.gltraining.mediaservice.entity.Video;
import com.gltraining.mediaservice.exception.InvalidArgumentException;
import com.gltraining.mediaservice.exception.MediaNotFoundException;
import com.gltraining.mediaservice.repository.MediaRepository;
import com.gltraining.mediaservice.util.MediaUtil;
import com.gltraining.mediaservice.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MediaServiceImp implements IMediaService {
    private MediaRepository mediaRepository;
    private Validator validator;
    private MediaUtil mediaUtil;
    public static final String MEDIA_NOT_FOUND = "Media is not found";

    @Autowired
    public MediaServiceImp(MediaRepository mediaRepository, Validator validator, MediaUtil mediaUtil) {
        this.mediaRepository = mediaRepository;
        this.validator = validator;
        this.mediaUtil = mediaUtil;
    }

    @Override
    public MediaDetails upload(UploadRequest requestDTO) throws InvalidArgumentException {
        Video video = new Video();
        video.setName(requestDTO.getName());
        video.setTitle(requestDTO.getTitle());
        video.setUploadedTo(requestDTO.getUploadedTo());
        Integer widthResolution = requestDTO.getWidthResolution();
        if (Boolean.TRUE.equals(validator.widthResolutionValidator(widthResolution))) {
            video.setWidthResolution(widthResolution);
        }
        Integer heightResolution = requestDTO.getHeightResolution();
        if (Boolean.TRUE.equals(validator.heightResolutionValidator(heightResolution))) {
            video.setHeightResolution(heightResolution);
        }
        return mediaUtil.toMediaDetails(mediaRepository.save(video));
    }

    @Override
    @Transactional
    public MediaDetails changeName(ChangeName requestDTO) throws MediaNotFoundException {
        Optional<Video> optional = mediaRepository.findById(requestDTO.getId());
        if (optional.isEmpty()) {
            throw new MediaNotFoundException(MEDIA_NOT_FOUND);
        }
        Video video = optional.get();
        video.setName(requestDTO.getName());
        return mediaUtil.toMediaDetails(video);
    }

    @Override
    public List<MediaDetails> findMediasByChannel(long channelID) throws MediaNotFoundException {

        List<Video> videoList = mediaRepository.findAll().stream().filter(m -> m.getUploadedTo().equals(channelID)).collect(Collectors.toList());
        if (videoList.isEmpty()) {
            throw new MediaNotFoundException(MEDIA_NOT_FOUND);
        }
        return mediaUtil.toMediaDetailsList(videoList);
    }

    @Override
    @Transactional
    public Boolean removeMedia(long mediaId) throws MediaNotFoundException {
        Optional<Video> optional = mediaRepository.findById(mediaId);
        if (optional.isEmpty()) {
            throw new MediaNotFoundException(MEDIA_NOT_FOUND);
        }
        mediaRepository.delete(optional.get());
        return true;
    }
}
