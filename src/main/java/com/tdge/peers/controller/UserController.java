package com.tdge.peers.controller;

import com.tdge.peers.model.User;
import com.tdge.peers.services.exceptions.UserAccountExistsException;
import com.tdge.peers.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userServiceImpl;
    Logger log = Logger.getLogger(UserController.class.getName());

    @Autowired
    public void setUserServiceImpl(UserService userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @PostMapping("/newUser")
    public ResponseEntity<User> createUser(@RequestBody User newUser) throws UserAccountExistsException {
        User aUser = null;
        try{
            aUser = userServiceImpl.save(newUser);
            log.info("Create user -> " + aUser.toString());
            return new ResponseEntity<>(aUser, HttpStatus.CREATED);
        } catch (UserAccountExistsException exception){
            System.err.println(exception.getMessage());
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/editUser")
    public ResponseEntity<User> updateUser(@RequestBody User editUser){
        try{
            User aUser = userServiceImpl.update(editUser);
            log.info("Updated user account -> " + aUser.toString());
            return new ResponseEntity<>(aUser, HttpStatus.ACCEPTED);
        } catch (UserAccountExistsException exception) {
            System.err.println(exception.getMessage());
        }
        return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }

    @GetMapping("/allUser")
    public ResponseEntity<List<User>> getAllUser(){
        List<User> allUser = userServiceImpl.findAll();
        log.info("all users -> " + allUser);
        return new ResponseEntity<>(allUser, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable("id") Long id) throws UserAccountExistsException {
        try{
            log.info("A particular user -> " + userServiceImpl.findUser(id));
            User oneUser = userServiceImpl.findUser(id);
            return new ResponseEntity<>(oneUser, HttpStatus.OK);
        }catch (UserAccountExistsException exception){
            System.err.println(exception.getMessage());
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

}
