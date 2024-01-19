package com.animousen4.game.engine.core.repositories;

import com.animousen4.game.engine.core.repositories.entities.UserEntity;
import com.animousen4.game.engine.core.repositories.entities.UserNamePassword;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserNamePasswordRepository extends JpaRepository<UserNamePassword, Long> {
    UserNamePassword findByUsername(String username);

}
