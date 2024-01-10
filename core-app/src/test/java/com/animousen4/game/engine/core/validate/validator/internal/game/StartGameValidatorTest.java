package com.animousen4.game.engine.core.validate.validator.internal.game;

import com.animousen4.game.engine.core.api.command.StartGameCommand;
import com.animousen4.game.engine.core.api.dto.game.GameInfoDTO;
import com.animousen4.game.engine.core.api.dto.game.SideInfoDTO;
import com.animousen4.game.engine.core.api.model.game.board.ChessClock;
import com.animousen4.game.engine.dto.ValidationError;
import com.animousen4.game.engine.rest.common.AbstractControllerBootTest;
import com.animousen4.game.engine.rest.common.AbstractTestcontainersConnections;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static com.animousen4.game.engine.core.values.AppConsts.MANDATORY_FIELD_MISSING;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class StartGameValidatorTest extends AbstractTestcontainersConnections {

    @Autowired
    private StartGameValidator validator;

    @Test
    void testBadRequestNullGameInfo() {
        StartGameCommand command =
                StartGameCommand.builder()
                        .gameInfo(null)
                        .build();

        List<ValidationError> errors = validator.validate(command);

        assertEquals(1, errors.size());

    }

    @Test
    void testBadRequestNullBlackSide() {
        StartGameCommand command =
                StartGameCommand.builder()
                        .gameInfo(
                                GameInfoDTO.builder()

                                        .whiteSide(buildSideInfoDto())
                                        .build()
                        )
                        .build();

        List<ValidationError> errors = validator.validate(command);

        assertEquals(1, errors.size());
        assertEquals(errors.get(0).getErrorCode(), MANDATORY_FIELD_MISSING);
    }

    @Test
    void testBadRequestNullWhiteSide() {
        StartGameCommand command =
                StartGameCommand.builder()
                        .gameInfo(
                                GameInfoDTO.builder()
                                        .blackSide(buildSideInfoDto())
                                        .build()
                        )
                        .build();

        List<ValidationError> errors = validator.validate(command);

        assertEquals(1, errors.size());
        assertEquals(errors.get(0).getErrorCode(), MANDATORY_FIELD_MISSING);
    }

    @Test
    void testBadRequestNullBlackAndWhiteSide() {
        StartGameCommand command =
                StartGameCommand.builder()
                        .gameInfo(
                                GameInfoDTO.builder()
                                        .build()
                        )
                        .build();

        List<ValidationError> errors = validator.validate(command);

        assertEquals(2, errors.size());
    }

    private SideInfoDTO buildSideInfoDto() {
        return SideInfoDTO.builder()
                .sideId(1L)
                .clock(ChessClock.builder()
                        .bonusTime(0L)
                        .leftTime(0L)
                        .build())
                .build();
    }

    private void printAllErrors(List<ValidationError> errors) {
        System.out.println("Errors amount: " + errors.size());
        errors.forEach(
                e -> System.out.println(e.toString())
        );
    }
}
