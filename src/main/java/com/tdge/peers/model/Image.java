package com.tdge.peers.model;

import com.tdge.peers.model.enums.PhotoType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long imageId;

    @ManyToOne
    private User user;

    private String imageName;

    private String imageDescription;

    private PhotoType imageType;

    private String imageUrl;

}
