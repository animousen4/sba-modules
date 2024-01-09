package com.animousen4.game.engine.core.repositories;

import com.animousen4.game.engine.core.repositories.entities.game.GameEntity;
import com.animousen4.game.engine.core.repositories.entities.game.GameStatusEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GameRepository extends JpaRepository<GameEntity, Long> {
    Optional<GameEntity> findGameEntityById(Long id);

}
