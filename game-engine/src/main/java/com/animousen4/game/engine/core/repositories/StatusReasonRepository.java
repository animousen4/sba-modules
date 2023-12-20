package com.animousen4.game.engine.core.repositories;

import com.animousen4.game.engine.core.repositories.entities.attributes.StatusReasonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusReasonRepository extends JpaRepository<StatusReasonEntity, Long> {
    StatusReasonEntity findStatusReasonEntityByStatusId(Long id);

}
