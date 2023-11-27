package com.animousen4.game.engine.core.services;

import com.animousen4.game.engine.core.underwriting.res.SolvePositionResult;
import com.animousen4.game.engine.core.validations.SolvePositionRequestValidator;
import com.animousen4.game.engine.dto.ValidationError;
import com.animousen4.game.engine.dto.v1.SomeRequestV1;
import com.animousen4.game.engine.dto.v1.SomeResponseV1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionSolverServiceImpl implements PositionSolverService {

    @Autowired
    SolvePositionRequestValidator validator;
    @Override
    public SomeResponseV1 solvePosition(SomeRequestV1 request) {
        List<ValidationError> errors = validator.validate(request);
        return errors.isEmpty() ?
                buildSuccessResponse(
                        request
                ) :
                buildErrorResponse(
                        errors
                );
    }

    SomeResponseV1 buildSuccessResponse(SomeRequestV1 request) {
        return SomeResponseV1.builder()

                .build();
    }

    SomeResponseV1 buildErrorResponse(List<ValidationError> errors) {
        return new SomeResponseV1(errors);
    }
}
