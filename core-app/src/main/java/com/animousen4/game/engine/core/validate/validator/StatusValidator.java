package com.animousen4.game.engine.core.validate.validator;

import com.animousen4.game.engine.dto.h1.ValidationError;
import com.animousen4.game.engine.dto.h1.v1.createOrUpdateUser.CreateOrUpdateUserRequestV1;

import java.util.List;

public class StatusValidator implements
        RequestValidatorInterface<CreateOrUpdateUserRequestV1> {

    @Override
    public List<ValidationError> validate(CreateOrUpdateUserRequestV1 entity) {
        return null;
    }
}
