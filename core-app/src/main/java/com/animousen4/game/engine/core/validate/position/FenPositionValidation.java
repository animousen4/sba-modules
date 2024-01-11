package com.animousen4.game.engine.core.validate.position;

import com.animousen4.game.engine.core.util.Placeholder;
import com.animousen4.game.engine.core.validate.ValidationErrorFactory;
import com.animousen4.game.engine.dto.h1.ValidationError;
import com.animousen4.game.engine.dto.h1.v1.solvePosition.SolvePositionRequestV1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

import static com.animousen4.game.engine.core.values.AppConsts.FIELD_NAME;
import static com.animousen4.game.engine.core.values.AppConsts.MANDATORY_FIELD_MISSING;

@Component
class FenPositionValidation extends PositionValidationImpl {
    @Autowired
    private ValidationErrorFactory errorFactory;

    @Override
    public Optional<ValidationError> validate(SolvePositionRequestV1 obj) {
        return (obj.getFenPosition() == null) ?
                Optional.of(errorFactory.buildError(MANDATORY_FIELD_MISSING, List.of(
                        new Placeholder(FIELD_NAME, "fenPosition")
                ))) :
                Optional.empty();
    }
}
