package com.animousen4.game.engine.rest.v1;

import com.animousen4.game.engine.rest.common.AbstractControllerBootTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class GameIntegrationStartGameControllerTest extends AbstractControllerBootTest {


    @Override
    protected String getBaseUrl() {
        return "/api/v1/game/start";
    }

    @Override
    protected String getJsonLocation() {
        return "rest/v1/game";
    }


    /*@Test
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
    }*/




}
