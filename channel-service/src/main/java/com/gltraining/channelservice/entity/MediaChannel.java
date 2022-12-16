package com.gltraining.channelservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class MediaChannel {
    @GeneratedValue
    @Id
    private Long id;

    private String name;

    private String createdBy;

}
