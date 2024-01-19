package com.animousen4.game.engine.core.services.factory;

import com.animousen4.game.engine.core.repositories.entities.UserEntity;
import com.animousen4.game.engine.core.values.UserStatus;

import java.util.Date;

public interface UserEntityFactory {
    UserEntity createNewUser(
            String username,
            String email,
            String password,
            UserStatus userStatus
    );
}
