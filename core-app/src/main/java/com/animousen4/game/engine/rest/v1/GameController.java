package com.animousen4.game.engine.rest.v1;

import com.animousen4.game.engine.core.api.command.MakeMoveCommand;
import com.animousen4.game.engine.core.api.command.StartGameCommand;
import com.animousen4.game.engine.core.api.result.AllCurrentGamesResult;
import com.animousen4.game.engine.core.api.result.GetGamePositionResult;
import com.animousen4.game.engine.core.api.result.MakeMoveResult;
import com.animousen4.game.engine.core.api.result.StartGameResult;
import com.animousen4.game.engine.core.services.GameManagerService;
import com.animousen4.game.engine.core.services.PlayingGameService;
import com.animousen4.game.engine.dto.h1.v1.getAllCurrentGames.GetAllCurrentGamesConverterV1;
import com.animousen4.game.engine.dto.h1.v1.getAllCurrentGames.GetAllCurrentGamesResponseV1;
import com.animousen4.game.engine.dto.h1.v1.makeMove.MakeMoveConverterV1;
import com.animousen4.game.engine.dto.h1.v1.makeMove.MakeMoveRequestV1;
import com.animousen4.game.engine.dto.h1.v1.makeMove.MakeMoveResponseV1;
import com.animousen4.game.engine.dto.h1.v1.startGame.StartGameConverterV1;
import com.animousen4.game.engine.dto.h1.v1.startGame.StartGameRequestV1;
import com.animousen4.game.engine.dto.h1.v1.startGame.StartGameResponseV1;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(
        path = "/api/v1/game",
        consumes = "application/json",
        produces = "application/json"
)
@RequiredArgsConstructor
public class GameController {
    final GameManagerService gameManagerService;

    final StartGameConverterV1 startGameConverterV1;

    final GetAllCurrentGamesConverterV1 getAllCurrentGamesConverterV1;

    final MakeMoveConverterV1 makeMoveConverterV1;

    final PlayingGameService playingGameService;
    @PostMapping("/start")
    public StartGameResponseV1 startGame(@RequestBody StartGameRequestV1 requestV1) {
        return buildResponseStartGame(requestV1);
    }

    @GetMapping("/getAllCurrentGames")
    public GetAllCurrentGamesResponseV1 getAllCurrentGames() {
        return buildResponseStartGame();
    }

    @GetMapping(path=
            "/getGamePosition/{id}",
            produces = MediaType.ALL_VALUE,
            consumes = MediaType.ALL_VALUE
    )
    public ResponseEntity<String> getGamePosition(@PathVariable Long id) {
        GetGamePositionResult gamePositionResult = gameManagerService.getGamePosition(id);

        return gamePositionResult.hasErrors()
                ? ResponseEntity.ok().body(gamePositionResult.getValidationErrors().toString())
                : ResponseEntity.ok().body(gamePositionResult.getPosition());
    }

    @GetMapping("/removeAllCurrentGames")
    public ResponseEntity<String> clearAllGames() {
        gameManagerService.removeAllCurrentGames();
        return ResponseEntity.ok().body("REMOVED");
    }

    @PostMapping("/makeMove")
    public MakeMoveResponseV1 startGame(@RequestBody MakeMoveRequestV1 requestV1) {
        return buildResponseMakeMove(requestV1);
    }

    MakeMoveResponseV1 buildResponseMakeMove(MakeMoveRequestV1 requestV1) {
        MakeMoveCommand command = makeMoveConverterV1.buildCommand(requestV1);
        MakeMoveResult res = playingGameService.makeMove(command);

        return makeMoveConverterV1.buildResponse(res);
    }


    StartGameResponseV1 buildResponseStartGame(StartGameRequestV1 requestV1) {
        StartGameCommand command = startGameConverterV1.buildCommand(requestV1);
        StartGameResult result = gameManagerService.startGame(command);

        return startGameConverterV1.buildResponse(result);
    }

    GetAllCurrentGamesResponseV1 buildResponseStartGame() {
        AllCurrentGamesResult result = gameManagerService.getAllCurrentGames();
        return getAllCurrentGamesConverterV1.buildResponse(result);
    }
}
