package com.animousen4.game.engine.core.api.model.user;

import com.animousen4.game.engine.core.values.UserStatus;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class UserModel {

    String updatedUsername;
    String username;
    String password;
    String email;

    UserStatus status;
}
