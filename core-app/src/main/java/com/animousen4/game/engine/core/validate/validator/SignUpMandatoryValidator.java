package com.animousen4.game.engine.core.validate.validator;

import com.animousen4.game.engine.core.api.command.SignUpCommand;
import com.animousen4.game.engine.core.validate.chaining.PrettyValidationErrorChaining;
import com.animousen4.game.engine.core.validate.validator.micro.MandatoryMicroValidator;
import com.animousen4.game.engine.dto.h1.ValidationError;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class SignUpMandatoryValidator implements AbstractValidatorInterface<SignUpCommand>{

    private final MandatoryMicroValidator mandatoryMicroValidator;

    private final UserDtoMandatoryValidator userDtoMandatoryValidator;
    @Override
    public List<ValidationError> validate(SignUpCommand entity) {
        return PrettyValidationErrorChaining.start()
                .go(
                        () -> entity,
                        x -> mandatoryMicroValidator.validate(x, "user")
                )
                .goList(
                        entity::getUser,
                        userDtoMandatoryValidator::validate
                )
                .validate();
    }
}
