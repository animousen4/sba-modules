package com.animousen4.game.engine.core.repositories;

import com.animousen4.game.engine.core.repositories.entities.UserRoleEntity;
import com.animousen4.game.engine.core.values.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRoleEntity, Long> {
    UserRoleEntity findUserRoleEntityByRole(UserRole userRole);
}
