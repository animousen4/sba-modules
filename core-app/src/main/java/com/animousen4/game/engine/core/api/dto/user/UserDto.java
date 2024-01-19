package com.animousen4.game.engine.core.api.dto.user;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserDto {

    String email;
    String username;
    String password;

}
