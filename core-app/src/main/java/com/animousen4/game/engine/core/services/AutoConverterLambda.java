package com.animousen4.game.engine.core.services;

import com.animousen4.game.engine.core.api.command.CoreCommand;
import com.animousen4.game.engine.core.api.result.CoreResult;

@FunctionalInterface
public interface AutoConverterLambda {
    <Command extends CoreCommand, Result extends CoreResult> Result action(Command command);
}