package com.animousen4.game.engine.dto;

import com.animousen4.game.engine.core.api.command.CoreCommand;
import com.animousen4.game.engine.core.api.result.CoreResult;

public abstract class AbstractConverter
        <Request extends CoreRequest, Command extends CoreCommand, Response extends CoreResponse, Result extends CoreResult> {
    public abstract Command buildCommand(Request request);
    public abstract Response buildResponse(Result result);
}
