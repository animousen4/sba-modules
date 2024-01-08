package com.animousen4.game.engine.core.services;

import com.animousen4.game.engine.core.api.command.CoreCommand;
import com.animousen4.game.engine.core.api.result.CoreResult;
import com.animousen4.game.engine.dto.AbstractConverter;
import com.animousen4.game.engine.dto.CoreRequest;
import com.animousen4.game.engine.dto.CoreResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.nio.charset.CoderResult;


@Component
public class AutoConverter{
    public <
            Request extends CoreRequest,
            Command extends CoreCommand,
            Response extends CoreResponse,
            Result extends CoreResult
            >
    Response convert(
            AutoConverterLambda actionLambda,
            AbstractConverter<Request, Command, Response, Result> converter,
            Request request
    ) {
        var command = converter.buildCommand(request);
        var result = actionLambda.action(command);
        return converter.buildResponse((Result) result);
    }
}
