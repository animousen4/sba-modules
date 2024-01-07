package com.animousen4.game.engine.core.services;

import com.animousen4.game.engine.core.api.command.CreateOrUpdateUserCommand;
import com.animousen4.game.engine.core.api.command.GetUserInfoCommand;
import com.animousen4.game.engine.core.api.result.CreateOrUpdateUserResult;
import com.animousen4.game.engine.core.api.result.GetUserInfoResult;

public interface UserService {

    GetUserInfoResult getUserInfo(GetUserInfoCommand getUserInfoCommand);

    CreateOrUpdateUserResult createOrUpdateUser(CreateOrUpdateUserCommand userCommand);
}
