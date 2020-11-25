package com.tdge.peers.model;

import com.tdge.peers.model.enums.GenderType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
//import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
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

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private GenderType genderType;

    private String phoneNumber;

    @OneToOne
    private Address address;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Role userRole;

    @Column(nullable = false)
//    @JsonIgnore
    @ToString.Exclude
    private String password;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Post> post;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Image> allImages;

    private String coverImage;

    private String dateOfBirth;

    private String profileImage;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Video> videos;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Friend> friends;


}
