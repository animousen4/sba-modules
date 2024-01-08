package com.animousen4.game.engine.rest.v1;

import com.animousen4.game.engine.core.api.command.StartGameCommand;
import com.animousen4.game.engine.core.api.result.StartGameResult;
import com.animousen4.game.engine.core.services.GameService;
import com.animousen4.game.engine.dto.v1.startGame.StartGameConverterV1;
import com.animousen4.game.engine.dto.v1.startGame.StartGameRequestV1;
import com.animousen4.game.engine.dto.v1.startGame.StartGameResponseV1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(
        path = "/api/v1/game",
        consumes = "application/json",
        produces = "application/json"
)
public class GameController {
    @Autowired
    GameService gameService;

    @Autowired
    StartGameConverterV1 startGameConverterV1;

    @PostMapping(
            path="/start"
    )
    public StartGameResponseV1 startGame(@RequestBody StartGameRequestV1 requestV1) {
        return buildResponseStartGame(requestV1);
    }

    StartGameResponseV1 buildResponseStartGame(StartGameRequestV1 requestV1) {
        StartGameCommand command = startGameConverterV1.buildCommand(requestV1);
        StartGameResult result = gameService.startGameRequest(command);

        return startGameConverterV1.buildResponse(result);
    }
}
