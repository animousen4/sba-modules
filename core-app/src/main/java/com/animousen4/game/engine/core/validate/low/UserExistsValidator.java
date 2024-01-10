package com.animousen4.game.engine.core.validate.low;

import com.animousen4.game.engine.core.validate.validator.AbstractValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class UserExistsValidator extends AbstractValidator<Long, UserExistsValidation> {

    private final UserExistsValidation userExistsValidation;
    @Override
    protected List<UserExistsValidation> validationComponentsList() {
        return List.of(userExistsValidation);
    }
}
