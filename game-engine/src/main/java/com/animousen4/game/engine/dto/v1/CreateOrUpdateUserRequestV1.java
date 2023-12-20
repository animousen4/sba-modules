package com.animousen4.game.engine.dto.v1;

import com.animousen4.game.engine.core.services.dto.UserDto;
import com.animousen4.game.engine.dto.CoreRequest;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateOrUpdateUserRequestV1 extends CoreRequest {
    UserDto user;
}
