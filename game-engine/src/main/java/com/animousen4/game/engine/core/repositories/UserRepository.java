package com.animousen4.game.engine.core.repositories;

import com.animousen4.game.engine.core.repositories.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    UserEntity getUserEntityById(long id);
}
