package com.gltraining.channelservice.dto;

import javax.validation.constraints.Min;

public class ChangeName {
    @Min(1)
    private Long id;
    private String name;

    @Min(0)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
