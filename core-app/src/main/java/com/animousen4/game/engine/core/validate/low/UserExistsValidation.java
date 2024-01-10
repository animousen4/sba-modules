package com.animousen4.game.engine.core.validate.low;

import com.animousen4.game.engine.core.repositories.UserRepository;
import com.animousen4.game.engine.core.util.Placeholder;
import com.animousen4.game.engine.core.validate.AbstractDefaultValidation;
import com.animousen4.game.engine.core.validate.ValidationErrorFactory;
import com.animousen4.game.engine.dto.ValidationError;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

import static com.animousen4.game.engine.core.values.AppConsts.*;

@Component
@RequiredArgsConstructor
public class UserExistsValidation
        implements AbstractDefaultValidation<Long> {

    private final UserRepository userRepository;

    private final ValidationErrorFactory validationErrorFactory;

    @Override
    public Optional<ValidationError> validate(Long id) {
        return userRepository.findUserEntityById(id) == null
                ? Optional.of(validationErrorFactory.buildError(USER_NOT_FOUND, new Placeholder(USER_ID, id)))
                : Optional.empty();
    }
}
