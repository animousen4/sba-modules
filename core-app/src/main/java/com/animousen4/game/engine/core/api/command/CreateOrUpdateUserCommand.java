package com.animousen4.game.engine.core.api.command;

import com.animousen4.game.engine.core.api.model.user.UserModel;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
public class CreateOrUpdateUserCommand extends CoreCommand{
    UserModel userModel;
}
