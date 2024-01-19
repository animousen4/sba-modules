package com.animousen4.game.engine.core.underwriting;

import com.animousen4.game.engine.core.api.command.SignUpCommand;
import com.animousen4.game.engine.core.api.result.JwtResult;

public interface SignUpUnderwriting {
    JwtResult signUpUser(SignUpCommand signUpCommand);
}
