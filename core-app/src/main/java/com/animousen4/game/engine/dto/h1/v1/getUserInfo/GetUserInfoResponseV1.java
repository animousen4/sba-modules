package com.animousen4.game.engine.dto.h1.v1.getUserInfo;

import com.animousen4.game.engine.core.services.dto.UserInfoDto;
import com.animousen4.game.engine.dto.h1.CoreResponse;
import com.animousen4.game.engine.dto.h1.ValidationError;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@SuperBuilder
public class GetUserInfoResponseV1 extends CoreResponse {

    UserInfoDto info;
    public GetUserInfoResponseV1(List<ValidationError> errors) {
        super(errors);
    }
}
