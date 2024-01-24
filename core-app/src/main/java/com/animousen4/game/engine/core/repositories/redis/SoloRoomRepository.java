package com.animousen4.game.engine.core.repositories.redis;

import com.animousen4.game.engine.core.repositories.entities.room.SoloRoomEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SoloRoomRepository extends CrudRepository<SoloRoomEntity, String> {

}
