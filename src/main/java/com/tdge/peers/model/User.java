package com.tdge.peers.model;

import lombok.ToString;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    private String username;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Gender gender;

    private String phoneNumber;

    @OneToOne
    private Address address;

    @Column(nullable = false)
    @JsonIgnore
    @ToString.Exclude
    private String password;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Image> allImages;

    private String coverImage;

    private Date dateOfBirth;

    private String profileImage;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Video> allVideos;

    @OneToMany
    private List<User> friends;
}
