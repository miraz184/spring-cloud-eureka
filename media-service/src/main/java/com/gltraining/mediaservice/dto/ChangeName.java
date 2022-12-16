package com.gltraining.mediaservice.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
public class ChangeName {
    @Min(1)
    private Long id;
    @NotBlank(message = "name can't be blank")
    @Length(min = 5, max = 20, message = "name should between 5 and 20")
    private String name;
}
