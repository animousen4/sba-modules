package com.animousen4.game.engine.core.underwriting;

import com.animousen4.game.engine.core.underwriting.res.UserCredsResult;

public interface UserCredsUnderwriting {
    UserCredsResult getUserCreds(String username);
}
