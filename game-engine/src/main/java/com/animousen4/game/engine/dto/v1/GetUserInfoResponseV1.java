package com.animousen4.game.engine.dto.v1;

import com.animousen4.game.engine.core.services.dto.UserCreds;
import com.animousen4.game.engine.dto.CoreResponse;
import com.animousen4.game.engine.dto.ValidationError;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@SuperBuilder
public class GetUserInfoResponseV1 extends CoreResponse {

    UserCreds creds;
    public GetUserInfoResponseV1(List<ValidationError> errors) {
        super(errors);
    }
}
