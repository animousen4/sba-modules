package com.animousen4.game.engine.core.validations;

import com.animousen4.game.engine.dto.CoreRequest;
import com.animousen4.game.engine.dto.ValidationError;
import com.animousen4.game.engine.dto.v1.CreateOrUpdateUserRequestV1;
import com.animousen4.game.engine.dto.v1.GetUserInfoRequestV1;

import java.util.List;

public class StatusValidator implements
        RequestValidator<CreateOrUpdateUserRequestV1>{

    @Override
    public List<ValidationError> validate(CreateOrUpdateUserRequestV1 entity) {
        return null;
    }
}
