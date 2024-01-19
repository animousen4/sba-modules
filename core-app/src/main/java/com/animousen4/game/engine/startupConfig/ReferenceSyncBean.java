package com.animousen4.game.engine.startupConfig;

import com.animousen4.game.engine.core.repositories.GameStatusRepository;
import com.animousen4.game.engine.core.repositories.UserRoleRepository;
import com.animousen4.game.engine.core.repositories.UserStatusRepository;
import com.animousen4.game.engine.core.repositories.entities.UserRoleEntity;
import com.animousen4.game.engine.core.repositories.entities.attributes.UserStatusEntity;
import com.animousen4.game.engine.core.repositories.entities.game.GameStatusEntity;
import com.animousen4.game.engine.core.values.GameStatus;
import com.animousen4.game.engine.core.values.UserRole;
import com.animousen4.game.engine.core.values.UserStatus;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Log4j2
@RequiredArgsConstructor
public class ReferenceSyncBean {

    private final GameStatusRepository gameStatusRepository;

    private final UserStatusRepository userStatusRepository;

    private final UserRoleRepository userRoleRepository;

    @EventListener
    public void contextStartupEvent(ContextRefreshedEvent event) throws InterruptedException {
        log.info("Started syncing all reference values");

        syncGameStatus();
        syncUserStatus();
        syncRoles();

        log.info("Finished syncing all reference values");

    }

    private void syncGameStatus() {
        log.info("Syncing game_status");
        Arrays.stream(GameStatus.values()).forEach(
                status -> {
                    GameStatusEntity entity =
                            gameStatusRepository.findGameStatusEntityByName(status);

                    if (entity == null) {
                        gameStatusRepository.save(
                                GameStatusEntity.builder()
                                        .name(status)
                                        .build()
                        );

                        log.info("Saved a new gameStatus: %s".formatted(status.name()));
                    }

                }
        );
    }

    private void syncUserStatus() {
        log.info("Syncing user_status");
        Arrays.stream(UserStatus.values()).forEach(
                status -> {
                    UserStatusEntity entity =
                            userStatusRepository.findStatusEntityByStatus(status);

                    if (entity == null){
                        userStatusRepository.save(
                                UserStatusEntity.builder()
                                        .status(status)
                                        .build()
                        );

                        log.info("Saved a new userStatus: %s".formatted(status.name()));
                    }
                }
        );
    }

    private void syncRoles() {
        log.info("Syncing user_roles");
        Arrays.stream(UserRole.values()).forEach(
                role -> {
                    UserRoleEntity entity =
                            userRoleRepository.findUserRoleEntityByRole(role);

                    if (entity == null) {
                        userRoleRepository.save(
                                UserRoleEntity.builder()
                                        .role(role)
                                        .build()
                        );

                        log.info("Saved a new gameStatus: %s".formatted(role.name()));
                    }

                }
        );
    }
}