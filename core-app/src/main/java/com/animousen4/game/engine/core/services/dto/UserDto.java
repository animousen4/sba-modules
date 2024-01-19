package com.animousen4.game.engine.core.services.dto;

import com.animousen4.game.engine.core.values.UserStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
    String updatedUsername;
    String username;
    String email;
    UserStatus status;
}
