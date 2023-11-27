package com.animousen4.game.engine.core.underwriting;

import com.animousen4.game.engine.core.underwriting.res.UserCredsResult;
import org.springframework.stereotype.Component;

@Component
class UserCredsUnderwritingImpl implements UserCredsUnderwriting{

    @Override
    public UserCredsResult getUserCreds(String username) {
        return null;
    }
}
