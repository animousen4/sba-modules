package com.animousen4.game.engine.config;

import com.animousen4.game.engine.core.repositories.GameStatusRepository;
import com.animousen4.game.engine.core.repositories.UserStatusRepository;
import com.animousen4.game.engine.core.repositories.entities.attributes.UserStatusEntity;
import com.animousen4.game.engine.core.repositories.entities.game.GameStatusEntity;
import com.animousen4.game.engine.core.values.GameStatus;
import com.animousen4.game.engine.core.values.UserStatus;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Optional;

@Component
@Log4j2
@RequiredArgsConstructor
public class ReferenceSyncBean {

    private final GameStatusRepository gameStatusRepository;

    private final UserStatusRepository userStatusRepository;
    @EventListener
    public void onApplicationEvent(ContextRefreshedEvent event) {
        log.info("Started syncing all reference values");

        syncGameStatus();
        syncUserStatus();

        log.info("Finished syncing all reference values");

    }

    private void syncGameStatus() {
        log.info("Started syncing game_status");
        Arrays.stream(GameStatus.values()).forEach(
                status -> {
                    Optional<GameStatusEntity> entity =
                            gameStatusRepository.findGameStatusEntityByName(status);

                    if (entity.isEmpty()){
                        gameStatusRepository.save(
                                GameStatusEntity.builder()
                                        .name(status)
                                        .build()
                        );

                        log.info("Saved a new gameStatus: %s".formatted(status.name()));
                    }
                }
        );
        log.info("Finished syncing game_status");
    }

    private void syncUserStatus() {
        log.info("Started syncing user_status");
        Arrays.stream(UserStatus.values()).forEach(
                status -> {
                    Optional<UserStatusEntity> entity =
                            userStatusRepository.findStatusEntityByName(status);

                    if (entity.isEmpty()){
                        userStatusRepository.save(
                                UserStatusEntity.builder()
                                        .name(status)
                                        .build()
                        );

                        log.info("Saved a new userStatus: %s".formatted(status.name()));
                    }
                }
        );

        log.info("Finished syncing user_status");
    }
}