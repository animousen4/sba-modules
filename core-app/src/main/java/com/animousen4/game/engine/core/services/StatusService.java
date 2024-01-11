package com.animousen4.game.engine.core.services;

import com.animousen4.game.engine.core.api.result.GetFullStatusInfoResult;
import com.animousen4.game.engine.dto.h1.v1.getFullStatusInfo.GetFullStatusInfoRequestV1;


public interface StatusService {
    GetFullStatusInfoResult getFullStatusInfo(GetFullStatusInfoRequestV1 request);
    boolean existsStatus(Long id);

}
