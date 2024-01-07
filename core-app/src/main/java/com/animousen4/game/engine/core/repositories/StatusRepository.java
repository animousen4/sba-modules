package com.animousen4.game.engine.core.repositories;

import com.animousen4.game.engine.core.repositories.entities.attributes.StatusEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusRepository extends JpaRepository<StatusEntity, Long> {
    StatusEntity findStatusEntityById(Long id);

}
