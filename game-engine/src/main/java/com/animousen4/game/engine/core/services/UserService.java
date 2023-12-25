package com.animousen4.game.engine.core.services;

import com.animousen4.game.engine.core.api.command.CreateOrUpdateUserCommand;
import com.animousen4.game.engine.core.api.result.CreateOrUpdateUserResult;
import com.animousen4.game.engine.core.services.dto.UserDto;
import com.animousen4.game.engine.core.underwriting.res.UserCredsResult;

public interface UserService {

    UserCredsResult getUserCredentials(Long id);

    CreateOrUpdateUserResult createOrUpdateUser(CreateOrUpdateUserCommand userCommand);
}
