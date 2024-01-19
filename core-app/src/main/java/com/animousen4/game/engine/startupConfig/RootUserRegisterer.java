package com.animousen4.game.engine.startupConfig;

import com.animousen4.game.engine.core.repositories.UserRepository;
import com.animousen4.game.engine.core.repositories.entities.UserEntity;
import com.animousen4.game.engine.core.services.factory.UserEntityFactory;
import com.animousen4.game.engine.core.values.UserRole;
import com.animousen4.game.engine.core.values.UserStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
class RootUserRegisterer {
    @Value("${user.root.username}")
    private String username;

    @Value("${user.root.password}")
    private String password;

    private final UserRepository userRepository;

    private final UserEntityFactory userEntityFactory;


    public void registerIfNotExists() {
        UserEntity ent = userRepository.findUserEntityByUsername(username);

        if (ent == null)
            registerRootUser();
    }

    private void registerRootUser() {
        UserEntity user = userEntityFactory.createPrivilegeUser(
                username,
                null,
                password,
                UserStatus.OK,
                List.of(UserRole.USER, UserRole.USER, UserRole.BOT)
        );

        userRepository.save(user);
    }
}
