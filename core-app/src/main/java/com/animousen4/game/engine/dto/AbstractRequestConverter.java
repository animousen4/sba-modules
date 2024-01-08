package com.animousen4.game.engine.dto;

import com.animousen4.game.engine.core.api.command.CoreCommand;

public interface AbstractRequestConverter
        <Request extends CoreRequest, Command extends CoreCommand> {
    Command buildCommand(Request request);
}
