package com.gltraining.mediaservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Video {
    @GeneratedValue
    @Id
    private Long id;
    private Integer widthResolution;

    private  Integer heightResolution;

    private Long uploadedTo; /// mediaChannel id

    private String name;

    private String title;
}
