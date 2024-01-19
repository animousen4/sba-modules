package com.animousen4.game.engine.core.validate.validator;

import com.animousen4.game.engine.core.api.command.SignInCommand;
import com.animousen4.game.engine.dto.h1.ValidationError;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class SignInExistValidator implements AbstractValidatorInterface<SignInCommand>{

    @Override
    public List<ValidationError> validate(SignInCommand entity) {
        return null;
    }
}
