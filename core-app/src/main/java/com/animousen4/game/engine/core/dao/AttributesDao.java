package com.animousen4.game.engine.core.dao;

import com.animousen4.game.engine.core.api.dto.StatusInfoDto;
import com.animousen4.game.engine.core.repositories.StatusReasonRepository;
import com.animousen4.game.engine.core.repositories.UserStatusRepository;
import com.animousen4.game.engine.core.repositories.entities.attributes.UserStatusEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AttributesDao {
    @Autowired
    UserStatusRepository userStatusRepository;

    @Autowired
    StatusReasonRepository statusReasonRepository;

    public boolean existStatusEntity(Long id) {
        return userStatusRepository.findStatusEntityById(id) != null;
    }
    public StatusInfoDto getEntityById(Long id) {
        UserStatusEntity status = userStatusRepository.findStatusEntityById(id);

        return StatusInfoDto.builder()
                .statusName(status.getStatus())
                .build();
    }
}
