package com.animousen4.game.engine.core.validate.validator;

import com.animousen4.game.engine.core.services.dto.UserDto;
import com.animousen4.game.engine.core.validate.UserValidation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class UserValidator extends AbstractValidator<UserDto, UserValidation>{
    final List<UserValidation> userValidationList;

    @Override
    protected List<UserValidation> validationComponentsList() {
        return userValidationList;
    }

}
