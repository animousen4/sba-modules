package com.animousen4.game.engine.core.underwriting;

import com.animousen4.game.engine.core.api.command.SignInCommand;
import com.animousen4.game.engine.core.api.result.JwtResult;
import com.animousen4.game.engine.dto.h1.ValidationError;

import java.util.List;

public interface SignInUnderwriting {

    JwtResult authenticateUser(SignInCommand command);
}
