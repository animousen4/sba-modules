package com.animousen4.game.engine.core.dao;

import com.animousen4.game.engine.core.repositories.entities.UserEntity;

public interface UserDao {
    UserEntity getUserById(Long id);

}
