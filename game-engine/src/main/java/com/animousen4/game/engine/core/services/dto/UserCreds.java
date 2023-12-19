package com.animousen4.game.engine.core.services.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserCreds {
    long id;
    String username;
    long statusId;
}
