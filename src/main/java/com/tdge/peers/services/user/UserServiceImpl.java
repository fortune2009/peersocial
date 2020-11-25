package com.tdge.peers.services.user;

import com.tdge.peers.model.User;
import com.tdge.peers.repositories.UserRepository;
import com.tdge.peers.services.exceptions.UserAccountExistsException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(User user) throws UserAccountExistsException{
       Optional<User> newUser = userRepository.findByEmail(user.getEmail());
       if (newUser.isPresent()){
           throw new UserAccountExistsException("An account already exists with this email. Please Try again! ");
       }
       else {
           return userRepository.save(user);
       }
    }

    @Override
    public User update(User user) throws UserAccountExistsException{
        Optional<User> newUser = userRepository.findByEmail(user.getEmail());
        if (newUser.isPresent()){
            newUser.get().setLastName(user.getLastName());
            newUser.get().setFirstName(user.getFirstName());
            newUser.get().setAddress(user.getAddress());
            newUser.get().setGenderType(user.getGenderType());
            newUser.get().setPhoneNumber(user.getPhoneNumber());
            User updatedUser = newUser.get();
            return userRepository.save(updatedUser);
        }
        else {
            throw new UserAccountExistsException("This account doesn't exist. Permission denied!");
        }
    }

    @Override
    public Optional<User> findById(Long userId) {
        return userRepository.findById(userId);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public void delete(Long userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public List<User> findUser(Long userId) {
        Optional<User> result = userRepository.findById(userId);

        if(result.isPresent()) {
            User presentUser = result.get();
            List<User> aUser = new ArrayList<>();
            aUser.add(presentUser);
            return aUser;
        }
        return null;
    }
}
