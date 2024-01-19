package com.animousen4.game.engine.core.services.factory;

import com.animousen4.game.engine.core.repositories.entities.UserEntity;
import com.animousen4.game.engine.core.values.UserRole;
import com.animousen4.game.engine.core.values.UserStatus;

import java.util.List;

public interface UserEntityFactory {
    UserEntity createNewUser(
            String username,
            String email,
            String password,
            UserStatus userStatus
    );

    UserEntity createPrivilegeUser(String username,
                                   String email,
                                   String password,
                                   UserStatus userStatus, List<UserRole> roles);
}
