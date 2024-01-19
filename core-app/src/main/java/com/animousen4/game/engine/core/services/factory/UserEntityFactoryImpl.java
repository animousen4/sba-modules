package com.animousen4.game.engine.core.services.factory;

import com.animousen4.game.engine.core.repositories.UserStatusRepository;
import com.animousen4.game.engine.core.repositories.entities.UserEntity;
import com.animousen4.game.engine.core.values.UserStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserEntityFactoryImpl implements UserEntityFactory{

    private final UserStatusRepository userStatusRepository;
    @Override
    public UserEntity createNewUser(
            String username,
            String email,
            String password,
            UserStatus userStatus
    ) {
        return UserEntity.builder()
                .email(email)
                .username(username)
                .status(
                        userStatusRepository.findStatusEntityByStatus(
                                userStatus
                        )
                )
                .password(password)
                .build();
    }
}
