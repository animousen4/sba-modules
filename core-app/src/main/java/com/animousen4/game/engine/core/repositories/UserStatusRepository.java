package com.animousen4.game.engine.core.repositories;

import com.animousen4.game.engine.core.repositories.entities.attributes.UserStatusEntity;
import com.animousen4.game.engine.core.values.UserStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserStatusRepository extends JpaRepository<UserStatusEntity, Long> {
    UserStatusEntity findStatusEntityById(Long id);

    Optional<UserStatusEntity> findStatusEntityByName(UserStatus status);

}
