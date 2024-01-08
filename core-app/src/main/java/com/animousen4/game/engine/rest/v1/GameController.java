package com.animousen4.game.engine.rest.v1;

import com.animousen4.game.engine.core.api.command.StartGameCommand;
import com.animousen4.game.engine.core.api.model.game.GameModel;
import com.animousen4.game.engine.core.api.result.AllCurrentGamesResult;
import com.animousen4.game.engine.core.api.result.StartGameResult;
import com.animousen4.game.engine.core.services.GameService;
import com.animousen4.game.engine.dto.v1.getAllCurrentGames.GetAllCurrentGamesConverterV1;
import com.animousen4.game.engine.dto.v1.getAllCurrentGames.GetAllCurrentGamesResponseV1;
import com.animousen4.game.engine.dto.v1.startGame.StartGameConverterV1;
import com.animousen4.game.engine.dto.v1.startGame.StartGameRequestV1;
import com.animousen4.game.engine.dto.v1.startGame.StartGameResponseV1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @Autowired
    GetAllCurrentGamesConverterV1 getAllCurrentGamesConverterV1;
    @PostMapping(
            "/start"
    )
    public StartGameResponseV1 startGame(@RequestBody StartGameRequestV1 requestV1) {
        return buildResponseGetAllGames(requestV1);
    }

    @GetMapping(
            "/getAllCurrentGames"
    )
    public GetAllCurrentGamesResponseV1 getAllCurrentGames() {
        return buildResponseGetAllGames();
    }

    StartGameResponseV1 buildResponseGetAllGames(StartGameRequestV1 requestV1) {
        StartGameCommand command = startGameConverterV1.buildCommand(requestV1);
        StartGameResult result = gameService.startGameRequest(command);

        return startGameConverterV1.buildResponse(result);
    }

    GetAllCurrentGamesResponseV1 buildResponseGetAllGames() {
        AllCurrentGamesResult result = gameService.getAllCurrentGames();
        return getAllCurrentGamesConverterV1.buildResponse(result);
    }
}
