package com.animousen4.game.engine.rest.v1;

import com.animousen4.game.engine.PostgresContainerSettings;
import com.animousen4.game.engine.TestContainerGameEngineConstants;
import com.animousen4.game.engine.rest.common.AbstractControllerTest;
import org.junit.ClassRule;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.testcontainers.containers.PostgreSQLContainer;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class GameControllerTest extends AbstractControllerTest {


    @Override
    protected String getBaseUrl() {
        return "/api/v1/game/start";
    }

    @Override
    protected String getJsonLocation() {
        return "rest/v1/game";
    }


    @Test
    void startNewGameTest() throws Exception {
        executeAndCompare("startGameTest");
    }
}
