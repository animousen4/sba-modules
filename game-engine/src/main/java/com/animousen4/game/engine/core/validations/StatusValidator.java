package com.animousen4.game.engine.core.validations;

import com.animousen4.game.engine.dto.ValidationError;
import com.animousen4.game.engine.dto.v1.createOrUpdateUser.CreateOrUpdateUserRequestV1;

import java.util.List;

public class StatusValidator implements
        RequestValidator<CreateOrUpdateUserRequestV1>{

    @Override
    public List<ValidationError> validate(CreateOrUpdateUserRequestV1 entity) {
        return null;
    }
}
