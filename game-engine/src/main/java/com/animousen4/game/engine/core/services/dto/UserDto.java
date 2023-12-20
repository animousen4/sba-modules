package com.animousen4.game.engine.core.services.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
    String username;
    String email;
    Long statusId;
    Long statusReasonId;
}
