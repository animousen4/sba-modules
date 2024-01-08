package com.animousen4.game.engine.core.services.autoconverter;

import com.animousen4.game.engine.core.api.command.CoreCommand;
import com.animousen4.game.engine.core.api.result.CoreResult;
import org.springframework.stereotype.Service;

@FunctionalInterface
interface ActionLambda<Command, Result> {
     Result process(Command command);
}
public class AutoConverter<Request, Response> {
     /*Response convert(Request r, ActionLambda actionLambda) {

     }*/
}
