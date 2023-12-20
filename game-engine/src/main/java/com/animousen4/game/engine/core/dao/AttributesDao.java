package com.animousen4.game.engine.core.dao;

import com.animousen4.game.engine.core.api.dto.StatusInfoDto;
import com.animousen4.game.engine.core.repositories.StatusReasonRepository;
import com.animousen4.game.engine.core.repositories.StatusRepository;
import com.animousen4.game.engine.core.repositories.entities.attributes.StatusEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AttributesDao {
    @Autowired
    StatusRepository statusRepository;

    @Autowired
    StatusReasonRepository statusReasonRepository;

    public boolean existStatusEntity(Long id) {
        return statusRepository.findStatusEntityById(id) != null;
    }
    public StatusInfoDto getEntityById(Long id) {
        StatusEntity status = statusRepository.findStatusEntityById(id);

        return StatusInfoDto.builder()
                .statusName(status.getName())
                .statusDescription(status.getDescription())
                .build();
    }
}
