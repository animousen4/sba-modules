package com.animousen4.game.engine.core.services.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserInfoDto {
    String username;
    String email;
    Long statusId;
    Long statusReasonId;
}
