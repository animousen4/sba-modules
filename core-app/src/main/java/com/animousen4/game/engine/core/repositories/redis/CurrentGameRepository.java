package com.animousen4.game.engine.core.repositories.redis;

import com.animousen4.game.engine.core.api.model.game.GameStoredModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrentGameRepository extends CrudRepository<GameStoredModel, Long> {
}
