package com.animousen4.game.engine.core.validations;

import com.animousen4.game.engine.core.services.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
class UserValidatorImpl extends AbstractValidator<UserDto, UserValidation> implements UserValidator {

    @Autowired
    List<UserValidation> userValidationList;

    @Override
    List<UserValidation> validationComponentsList() {
        return userValidationList;
    }

}
