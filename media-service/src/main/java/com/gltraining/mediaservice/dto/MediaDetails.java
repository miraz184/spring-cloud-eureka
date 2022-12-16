package com.gltraining.mediaservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MediaDetails {
    private Long id;
    private Integer widthResolution;
    private Integer heightResolution;
    private Long uploadedTo;
    private String name;
    private String title;
}
