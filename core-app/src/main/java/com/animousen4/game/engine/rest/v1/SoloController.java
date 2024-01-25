package com.animousen4.game.engine.rest.v1;

import com.animousen4.game.engine.core.api.command.SignInCommand;
import com.animousen4.game.engine.core.api.command.SignUpCommand;
import com.animousen4.game.engine.core.api.command.SoloGameSearchCommand;
import com.animousen4.game.engine.core.api.result.JwtResult;
import com.animousen4.game.engine.core.services.room.SoloRoomService;
import com.animousen4.game.engine.dto.h1.entities.room.solo.SoloGameInfoDto;
import com.animousen4.game.engine.dto.h1.v1.searchSoloGame.SearchSoloGameConverterV1;
import com.animousen4.game.engine.dto.h1.v1.searchSoloGame.SoloGameSearchRequest;
import com.animousen4.game.engine.dto.h1.v1.searchSoloGame.SoloGameSearchResponse;
import com.animousen4.game.engine.security.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(
        value = "/api/v1/game/solo",
        consumes = APPLICATION_JSON_VALUE,
        produces = APPLICATION_JSON_VALUE
)
@RequiredArgsConstructor
public class SoloController {

    private final SoloRoomService soloRoomService;

    private final SearchSoloGameConverterV1 searchSoloGameConverterV1;
    @PostMapping("/search")
    SoloGameSearchResponse searchSoloGame(@RequestBody SoloGameSearchRequest searchRequest) {
        return buildSearchGameResponse(searchRequest);
    }

    private SoloGameSearchResponse buildSearchGameResponse(SoloGameSearchRequest searchRequest) {
        SoloGameSearchCommand command = searchSoloGameConverterV1.buildCommand(searchRequest);
        var result = soloRoomService.searchSoloGame(command);

        return searchSoloGameConverterV1.buildResponse(result);
    }


}
