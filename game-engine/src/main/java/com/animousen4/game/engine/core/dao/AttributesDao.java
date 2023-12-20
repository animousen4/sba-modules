package com.animousen4.game.engine.core.dao;

import com.animousen4.game.engine.core.api.dto.FullStatusInfoDto;
import com.animousen4.game.engine.core.repositories.StatusReasonRepository;
import com.animousen4.game.engine.core.repositories.StatusRepository;
import com.animousen4.game.engine.core.repositories.entities.attributes.StatusEntity;
import com.animousen4.game.engine.core.repositories.entities.attributes.StatusReasonEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AttributesDao {
    @Autowired
    StatusRepository attributesRepository;

    @Autowired
    StatusReasonRepository statusReasonRepository;

    public FullStatusInfoDto getEntityById(Long id) {
        StatusEntity status = attributesRepository.findStatusEntityById(id);
        StatusReasonEntity statusReasonEntity = statusReasonRepository.findStatusReasonEntityById(
                status.getId()
        );
        return FullStatusInfoDto.builder()
                .statusName(status.getName())
                .statusDescription(status.getDescription())
                .statusNameReason(statusReasonEntity.getName())
                .statusNameDescription(statusReasonEntity.getDescription())
                .build();
    }
}
