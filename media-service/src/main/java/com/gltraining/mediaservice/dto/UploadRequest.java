package com.gltraining.mediaservice.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
public class UploadRequest {
    private Integer widthResolution;
    private Integer heightResolution;
    @Min(1)
    private Long uploadedTo;
    @NotBlank(message = "name can't be blank")
    @Length(min = 5, max = 20, message = "name should between 5 and 20")
    private String name;
    private String title;
}
