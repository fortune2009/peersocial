package com.tdge.peers.model;

import com.tdge.peers.model.enums.VideoType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data

@Entity
public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long videoId;

    @ManyToOne
    private User user;

    private String videoName;

    private VideoType videoType;

    private String videoDescription;

    private String videoUrl;

}
