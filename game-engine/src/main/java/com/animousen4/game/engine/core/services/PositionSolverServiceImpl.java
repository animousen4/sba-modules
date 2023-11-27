package com.animousen4.game.engine.core.services;

import com.animousen4.game.engine.core.underwriting.SolvePositionUnderwriting;
import com.animousen4.game.engine.core.underwriting.res.SolvePositionResult;
import com.animousen4.game.engine.core.validations.SolvePositionRequestValidator;
import com.animousen4.game.engine.dto.ValidationError;
import com.animousen4.game.engine.dto.v1.SolvePositionRequestV1;
import com.animousen4.game.engine.dto.v1.SolvePositionResponseV1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionSolverServiceImpl implements PositionSolverService {

    @Autowired
    SolvePositionUnderwriting solvePositionUnderwriting;

    @Autowired
    SolvePositionRequestValidator validator;
    @Override
    public SolvePositionResponseV1 solvePosition(SolvePositionRequestV1 request) {
        List<ValidationError> errors = validator.validate(request);
        return errors.isEmpty() ?
                buildSuccessResponse(
                        request,
                        solvePositionUnderwriting.calculateBestMove(request)
                ) :
                buildErrorResponse(
                        errors
                );
    }

    SolvePositionResponseV1 buildSuccessResponse(SolvePositionRequestV1 request, SolvePositionResult solveResult) {
        return SolvePositionResponseV1.builder()
                .bestMove(solveResult.getBestMove())
                .bestMoveVariant(solveResult.getBestVariant())
                .build();
    }

    SolvePositionResponseV1 buildErrorResponse(List<ValidationError> errors) {
        return new SolvePositionResponseV1(errors);
    }
}
