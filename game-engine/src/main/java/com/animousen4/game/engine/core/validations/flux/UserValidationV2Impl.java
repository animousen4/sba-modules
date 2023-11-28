package com.animousen4.game.engine.core.validations.flux;

import com.animousen4.game.engine.core.validations.ValidationErrorFactory;
import com.animousen4.game.engine.dto.User;
import com.animousen4.game.engine.dto.ValidationError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static com.animousen4.game.engine.core.consts.AppConsts.MANDATORY_FIELD_MISSING;

@Component
class UserValidationV2Impl implements UserValidationV2{
    @Autowired
    ValidationErrorFactory validationErrorFactory;
    @Override
    public Flux<ValidationError> validate(User object) {
        return Flux.empty();
    }
}
