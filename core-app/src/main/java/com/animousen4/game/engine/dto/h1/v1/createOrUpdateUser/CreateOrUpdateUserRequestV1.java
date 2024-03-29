package com.animousen4.game.engine.dto.h1.v1.createOrUpdateUser;

import com.animousen4.game.engine.core.services.dto.UserDto;
import com.animousen4.game.engine.dto.h1.CoreRequest;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateOrUpdateUserRequestV1 extends CoreRequest {
    private UserDto user;
}
