package com.tdge.peers.model;

import com.tdge.peers.model.enums.PostType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;

    private String postTitle;

    private PostType postType;

    private String postDescription;

    @ManyToOne
    private User userId;

    @OneToOne
    private Shares sharePost;
}
