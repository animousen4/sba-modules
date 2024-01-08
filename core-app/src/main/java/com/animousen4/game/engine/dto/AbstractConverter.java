package com.animousen4.game.engine.dto;

import com.animousen4.game.engine.core.api.command.CoreCommand;
import com.animousen4.game.engine.core.api.result.CoreResult;

public interface AbstractConverter
                <Request extends CoreRequest,
                Command extends CoreCommand,
                Response extends CoreResponse,
                Result extends CoreResult>
        extends AbstractRequestConverter<Request, Command>,
                AbstractResultConverter<Response, Result> {

}
