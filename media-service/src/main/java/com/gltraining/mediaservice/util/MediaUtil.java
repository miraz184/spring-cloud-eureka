package com.gltraining.mediaservice.util;

import com.gltraining.mediaservice.dto.MediaDetails;
import com.gltraining.mediaservice.entity.Video;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MediaUtil {
    public MediaDetails toMediaDetails(Video video) {
        MediaDetails desired = new MediaDetails();
        desired.setId(video.getId());
        desired.setName(video.getName());
        desired.setTitle(video.getTitle());
        desired.setUploadedTo(video.getUploadedTo());
        desired.setWidthResolution(video.getWidthResolution());
        desired.setHeightResolution(video.getHeightResolution());
        return desired;
    }

    public List<MediaDetails> toMediaDetailsList(List<Video> videos) {
        List<MediaDetails> mediaList = new ArrayList<>();
        for (Video item : videos) {
            mediaList.add(new MediaDetails(item.getId(), item.getWidthResolution(),
                    item.getHeightResolution(), item.getUploadedTo(), item.getName(), item.getTitle()));
        }
        return mediaList;
    }

}
