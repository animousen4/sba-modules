package com.animousen4.game.engine.core.services.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
    Long id;
    String username;
    String oldUsername;
    String email;
    Long statusId;
    Long statusReasonId;
}
