package com.animousen4.game.engine.core.services.room;

import com.animousen4.game.engine.core.api.command.SoloGameSearchCommand;
import com.animousen4.game.engine.core.api.result.SoloGameSearchResult;
import com.animousen4.game.engine.core.validate.game.room.solo.SoloGameSearchCommandValidator;
import com.animousen4.game.engine.dto.h1.ValidationError;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SoloRoomServiceImpl implements SoloRoomService{

    private final SoloGameSearchCommandValidator validator;
    @Override
    public SoloGameSearchResult searchSoloGame(SoloGameSearchCommand command) {
        List<ValidationError> errors = validator.validate(command);

        if (errors.isEmpty())
            return buildSuccessResult(command);
        else
            return buildFailResult(errors);
    }

    private SoloGameSearchResult buildSuccessResult(SoloGameSearchCommand command) {
        // test id
        return SoloGameSearchResult.builder()
                .requestId(UUID.randomUUID().toString())
                .build();
    }

    private SoloGameSearchResult buildFailResult(List<ValidationError> errors) {
        return SoloGameSearchResult.builder()
                .validationErrors(errors)
                .build();
    }
}
