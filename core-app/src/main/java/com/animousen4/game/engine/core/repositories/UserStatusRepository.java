package com.animousen4.game.engine.core.repositories;

import com.animousen4.game.engine.core.repositories.entities.attributes.UserStatusEntity;
import com.animousen4.game.engine.core.values.UserStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserStatusRepository extends JpaRepository<UserStatusEntity, Long> {
    UserStatusEntity findStatusEntityById(Long id);

   UserStatusEntity findStatusEntityByStatus(UserStatus status);

}
