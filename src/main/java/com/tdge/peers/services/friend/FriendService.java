package com.tdge.peers.services.friend;

import com.tdge.peers.model.Friend;

import java.util.Optional;

public interface FriendService {

    Friend save(Friend friend);
    Friend update(Friend friend);
    void delete(Long id);
    Optional<Friend> findById(Long id);
    Optional<Friend> findAll();

}
