package com.animousen4.game.engine.core.api.model.user;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class UserModel {

    String updatedUsername;
    String username;
    String email;

    Long statusId;
    Long statusReasonId;
}
