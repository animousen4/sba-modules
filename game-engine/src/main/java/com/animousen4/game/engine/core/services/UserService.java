package com.animousen4.game.engine.core.services;

import com.animousen4.game.engine.core.underwriting.res.UserCredsResult;

public interface UserService {

    UserCredsResult getUserCredentials(long id);
}
