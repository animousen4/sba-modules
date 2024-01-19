package com.animousen4.game.engine.core.services.factory;

import com.animousen4.game.engine.core.repositories.UserRoleRepository;
import com.animousen4.game.engine.core.repositories.UserStatusRepository;
import com.animousen4.game.engine.core.repositories.entities.UserEntity;
import com.animousen4.game.engine.core.util.DateTimeUtil;
import com.animousen4.game.engine.core.values.UserRole;
import com.animousen4.game.engine.core.values.UserStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class UserEntityFactoryImpl implements UserEntityFactory{

    private final UserStatusRepository userStatusRepository;

    private final UserRoleRepository userRoleRepository;

    private final PasswordEncoder passwordEncoder;

    private final DateTimeUtil timeUtil;
    @Override
    public UserEntity createNewUser(
            String username,
            String email,
            String rawPassword,
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
                .registrationDate(timeUtil.getCurrentTimestamp())
                .roles(
                        List.of(
                                userRoleRepository.findUserRoleEntityByRole(UserRole.USER)
                        )
                )
                .password(passwordEncoder.encode(rawPassword))
                .build();
    }

    @Override
    public UserEntity createPrivilegeUser(String username, String email, String rawPassword, UserStatus userStatus, List<UserRole> roles) {
        return UserEntity.builder()
                .email(email)
                .username(username)
                .status(
                        userStatusRepository.findStatusEntityByStatus(
                                userStatus
                        )
                )
                .registrationDate(timeUtil.getCurrentTimestamp())
                .roles(
                        roles.stream().map(
                                userRoleRepository::findUserRoleEntityByRole
                        ).collect(Collectors.toList())
                )
                .password(passwordEncoder.encode(rawPassword))
                .build();
    }

}
