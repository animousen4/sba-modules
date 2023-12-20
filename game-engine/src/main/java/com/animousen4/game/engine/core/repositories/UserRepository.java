package com.animousen4.game.engine.core.repositories;

import com.animousen4.game.engine.core.repositories.entities.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {
    UserEntity findUserEntityById(long id);
}
