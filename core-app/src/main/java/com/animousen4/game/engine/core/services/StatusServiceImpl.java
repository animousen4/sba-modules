package com.animousen4.game.engine.core.services;

import com.animousen4.game.engine.core.api.result.GetFullStatusInfoResult;
import com.animousen4.game.engine.core.dao.AttributesDao;
import com.animousen4.game.engine.core.util.Placeholder;
import com.animousen4.game.engine.core.validate.ValidationErrorFactory;
import com.animousen4.game.engine.dto.v1.getFullStatusInfo.GetFullStatusInfoRequestV1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.animousen4.game.engine.core.values.AppConsts.STATUS_ID;
import static com.animousen4.game.engine.core.values.AppConsts.STATUS_NOT_FOUND;


@Service
class StatusServiceImpl implements StatusService{

    @Autowired
    AttributesDao attributesDao;

    @Autowired
    ValidationErrorFactory validationErrorFactory;

    public boolean existsStatus(Long id) {
        return attributesDao.existStatusEntity(id);
    }
    public GetFullStatusInfoResult getFullStatusInfo(GetFullStatusInfoRequestV1 request) {
        return attributesDao.existStatusEntity(request.getId()) ?
                GetFullStatusInfoResult.builder()
                        .statusInfo(
                                attributesDao.getEntityById(request.getId())
                        )
                        .build() :
                GetFullStatusInfoResult.builder()
                        .validationErrors(
                                List.of(validationErrorFactory.buildError(STATUS_NOT_FOUND, new Placeholder(STATUS_ID, request.getId())))
                        )
                        .build();
    }


}
