package com.tdge.peers.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Friend {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long friendId;

    @Column(nullable = false)
    private String friendName;

    @Column(nullable = false)
    private String friendEmail;

    @OneToOne
    private Address address;

    private String friendUserName;

    @ManyToOne
    private User user;


}
