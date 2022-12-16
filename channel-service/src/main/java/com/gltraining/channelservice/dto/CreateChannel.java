package com.gltraining.channelservice.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@Data
public class CreateChannel {
    @NotBlank(message = "name can't be blank ")
    @Length(min = 3, max = 20, message = "name should between 3 and 20")
    private String name;
    @NotBlank(message = "name can't be blank ")
    @Length(min = 2, max = 15, message = "name should between 2 and 15")
    private String createdBy;

}
