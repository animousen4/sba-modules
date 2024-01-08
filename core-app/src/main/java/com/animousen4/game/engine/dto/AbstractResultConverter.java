package com.animousen4.game.engine.dto;

import com.animousen4.game.engine.core.api.result.CoreResult;

public interface AbstractResultConverter
        <Response extends CoreResponse, Result extends CoreResult> {
    Response buildResponse(Result result);
}
