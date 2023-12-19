package com.animousen4.game.engine.core.validations.user;

import com.animousen4.game.engine.core.consts.AppConsts;
import com.animousen4.game.engine.core.util.Placeholder;
import com.animousen4.game.engine.core.validations.UserValidation;
import com.animousen4.game.engine.core.validations.ValidationErrorFactory;
import com.animousen4.game.engine.dto.UserDto;
import com.animousen4.game.engine.dto.ValidationError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


@Component
class UserMandatoryValidation implements UserValidation {

    @Autowired
    ValidationErrorFactory validationErrorFactory;

    @Override
    public Optional<ValidationError> validate(UserDto obj) {
        return obj != null ?
                Optional.empty() :
                Optional.of(
                        validationErrorFactory.
                                buildError(
                                        AppConsts.MANDATORY_FIELD_MISSING,
                                        List.of(
                                                new Placeholder(
                                                        AppConsts.FIELD_NAME,
                                                        "user"
                                                )
                                        )
                                )
                );
    }



    @Override
    public List<ValidationError> validateList(UserDto obj) {

        return null;
    }
}
