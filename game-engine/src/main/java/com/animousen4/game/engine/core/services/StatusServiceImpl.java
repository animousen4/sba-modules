package com.animousen4.game.engine.core.services;

import com.animousen4.game.engine.core.api.command.GetFullStatusInfoResult;
import com.animousen4.game.engine.core.dao.AttributesDao;
import com.animousen4.game.engine.core.api.dto.FullStatusInfoDto;
import com.animousen4.game.engine.core.validations.ValidationErrorFactory;
import com.animousen4.game.engine.dto.v1.GetFullStatusInfoRequestV1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.animousen4.game.engine.core.consts.AppConsts.STATUS_NOT_FOUND;


@Service
public class StatusServiceImpl implements StatusService{

    @Autowired
    AttributesDao attributesDao;

    @Autowired
    ValidationErrorFactory validationErrorFactory;
    public GetFullStatusInfoResult getFullStatusInfo(GetFullStatusInfoRequestV1 request) {
        FullStatusInfoDto dto = attributesDao.getEntityById(request.getId());

        return dto != null ?
                GetFullStatusInfoResult.builder()
                        .fullStatusInfo(dto)
                        .build() :
                GetFullStatusInfoResult.builder()
                        .validationErrors(
                                List.of(validationErrorFactory.buildError(STATUS_NOT_FOUND))
                        )
                        .build();
    }


}
