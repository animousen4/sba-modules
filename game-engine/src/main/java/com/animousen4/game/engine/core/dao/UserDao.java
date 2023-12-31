package com.animousen4.game.engine.core.dao;

import com.animousen4.game.engine.core.repositories.UserRepository;
import com.animousen4.game.engine.core.repositories.entities.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserDao{

    @Autowired
    UserRepository userRepository;

    public UserEntity getUserById(Long id) {
        return userRepository.findUserEntityById(id);
    }
    public UserEntity getUserByUsername(String username) {
        return userRepository.findUserEntityByUsername(username);
    }
    public void updateUserById(UserEntity user) {
        userRepository.save(user);
    }
}
