package com.animousen4.game.engine.core.services;

import com.animousen4.game.engine.core.api.command.GetFullStatusInfoResult;
import com.animousen4.game.engine.dto.v1.GetFullStatusInfoRequestV1;


public interface StatusService {
    GetFullStatusInfoResult getFullStatusInfo(GetFullStatusInfoRequestV1 request);
    boolean existsStatus(Long id);

}
