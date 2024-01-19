package com.animousen4.game.engine.core.services.dto;

import com.animousen4.game.engine.core.values.UserStatus;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserInfoDto {
    String username;
    String email;
    UserStatus status;
}
