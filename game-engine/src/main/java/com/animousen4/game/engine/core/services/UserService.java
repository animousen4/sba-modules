package com.animousen4.game.engine.core.services;

import com.animousen4.game.engine.core.underwriting.res.UserCredsResult;
import org.springframework.data.jpa.repository.Query;

public interface UserService {

    UserCredsResult getUserCredentials(long id);
}
