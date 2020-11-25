package com.tdge.peers.services.user;

import com.tdge.peers.model.User;
import com.tdge.peers.services.exceptions.UserAccountExistsException;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User save(User user) throws UserAccountExistsException;

    User update(User user) throws UserAccountExistsException;

    Optional<User> findById(Long userId);

    Optional<User> findByEmail(String email);

    void delete(Long userId);

    List<User> findAll();

    List<User> findUser(Long userId);

}
