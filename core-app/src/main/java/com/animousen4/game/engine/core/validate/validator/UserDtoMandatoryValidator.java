package com.animousen4.game.engine.core.validate.validator;

import com.animousen4.game.engine.core.api.dto.user.UserDto;
import com.animousen4.game.engine.core.validate.chaining.PrettyValidationErrorChaining;
import com.animousen4.game.engine.core.validate.validator.micro.MandatoryMicroValidator;
import com.animousen4.game.engine.dto.h1.ValidationError;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class UserDtoMandatoryValidator implements AbstractValidatorInterface<UserDto>{

    private final MandatoryMicroValidator mandatoryMicroValidator;
    @Override
    public List<ValidationError> validate(UserDto entity) {
        return PrettyValidationErrorChaining.start()
                .parallel(
                        v -> v.go(
                                entity::getUsername,
                                x -> mandatoryMicroValidator.validate(x, "username")
                        )
                )
                .parallel(
                        v -> v.go(
                                entity::getPassword,
                                x -> mandatoryMicroValidator.validate(x, "password")
                        )
                )
                .parallel(
                        v -> v.go(
                                entity::getEmail,
                                x -> mandatoryMicroValidator.validate(x, "email")
                        )
                )
                .validate();
    }
}
