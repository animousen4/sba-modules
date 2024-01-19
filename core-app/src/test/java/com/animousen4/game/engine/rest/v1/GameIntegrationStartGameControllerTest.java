package com.animousen4.game.engine.rest.v1;

import com.animousen4.game.engine.RootUserLoader;
import com.animousen4.game.engine.core.api.command.SignInCommand;
import com.animousen4.game.engine.rest.common.AbstractControllerBootTest;
import com.animousen4.game.engine.security.service.AuthenticationService;
import com.animousen4.game.engine.security.service.JwtService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class GameIntegrationStartGameControllerTest extends AbstractControllerBootTest {

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private RootUserLoader userLoader;
    @Override
    protected String getBaseUrl() {
        return "/api/v1/game/start";
    }

    @Override
    protected String getJsonLocation() {
        return "rest/v1/game";
    }

    @Override
    protected String getJwtToken() {
        return userLoader.getRootUserJwt().getJwt();
    }


    @Test
    void startNewGameFullOkTest() throws Exception {
        executeAndCompare("startGameFullOkTest");
    }

    @Test
    void startNewGameMissMandatoryBlackSideTest() throws Exception {
        executeAndCompare("startGameMissMandatoryBlackSideTest");
    }

    @Test
    void startNewGameMissMandatoryWhiteSideTest() throws Exception {
        executeAndCompare("startGameMissMandatoryWhiteSideTest");
    }

    @Test
    void startNewGameMissMandatoryBothSidedTest() throws Exception {
        executeAndCompare("startGameMissMandatoryBothSidesTest");
    }

    @Test
    void startNewGameMissMandatoryGameInfoTest() throws Exception {
        executeAndCompare("startGameMissMandatoryGameInfoTest");
    }




}
