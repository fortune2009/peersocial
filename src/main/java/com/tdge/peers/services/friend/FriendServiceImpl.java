package com.tdge.peers.services.friend;

import com.tdge.peers.model.Friend;
import com.tdge.peers.repositories.FriendRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FriendServiceImpl implements FriendService{
    private final FriendRepository friendRepository;

    public FriendServiceImpl(FriendRepository friendRepository) {
        this.friendRepository = friendRepository;
    }

    @Override
    public Friend save(Friend friend) {
        return friendRepository.save(friend);
    }

    @Override
    public Friend update(Friend friend) {
        Optional<Friend> searchFriendResult = friendRepository.findById(friend.getFriendId());
        if (searchFriendResult.isPresent()){

        }
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Optional<Friend> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<Friend> findAll() {
        return Optional.empty();
    }
}
