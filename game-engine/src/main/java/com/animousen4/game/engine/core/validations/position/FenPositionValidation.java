package com.animousen4.game.engine.core.validations.position;

import com.animousen4.game.engine.core.util.Placeholder;
import com.animousen4.game.engine.core.validations.PositionValidation;
import com.animousen4.game.engine.core.validations.ValidationErrorFactory;
import com.animousen4.game.engine.dto.ValidationError;
import com.animousen4.game.engine.dto.v1.SolvePositionRequestV1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

import static com.animousen4.game.engine.core.consts.AppConsts.FIELD_NAME;
import static com.animousen4.game.engine.core.consts.AppConsts.MANDATORY_FIELD_MISSING;

@Component
class FenPositionValidation extends PositionValidationImpl {
    @Autowired
    private ValidationErrorFactory errorFactory;

    @Override
    public Optional<ValidationError> validate(SolvePositionRequestV1 request) {
        return (request.getFenPosition() == null) ?
                Optional.of(errorFactory.buildError(MANDATORY_FIELD_MISSING, List.of(
                        new Placeholder(FIELD_NAME, "fenPosition")
                ))) :
                Optional.empty();
    }
}
