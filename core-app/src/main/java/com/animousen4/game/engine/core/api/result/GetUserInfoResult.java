package com.animousen4.game.engine.core.api.result;

import com.animousen4.game.engine.core.api.model.user.UserModel;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
public class GetUserInfoResult extends CoreResult{
    UserModel userModel;
}
