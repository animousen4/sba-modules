package com.animousen4.game.engine.core.repositories;

import com.animousen4.game.engine.core.repositories.entities.game.GameStatusEntity;
import com.animousen4.game.engine.core.values.GameStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GameStatusRepository extends JpaRepository<GameStatusEntity, Long> {
    Optional<GameStatusEntity> findGameStatusEntityById(Long id);

    GameStatusEntity findGameStatusEntityByName(GameStatus status);


}
