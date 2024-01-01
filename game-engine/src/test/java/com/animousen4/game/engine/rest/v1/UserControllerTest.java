package com.animousen4.game.engine.rest.v1;

import com.animousen4.game.engine.GameEngineContainerSettings;
import com.animousen4.game.engine.TestContainerGameEngineConstants;
import com.animousen4.game.engine.rest.common.AbstractControllerTest;

import org.junit.ClassRule;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.testcontainers.containers.PostgreSQLContainer;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest extends AbstractControllerTest {
    @Override
    protected String getBaseUrl() {
        return "/api/v1/user/createOrUpdateUser";
    }

    @Override
    protected String getJsonLocation() {
        return "rest/v1";
    }


    @ClassRule
    public static PostgreSQLContainer<GameEngineContainerSettings> postgreSQLContainer =
            GameEngineContainerSettings.getInstance(TestContainerGameEngineConstants.INIT_DB_SCRIPT_PATH);

    //tests

    @BeforeAll()
    static void beforeAll() {
        postgreSQLContainer.start();
    }

    @AfterAll()
    static void afterAll() {
        postgreSQLContainer.stop();
    }

    @Sql(scripts = {
            "script/fillStatus.sql",
            "script/fillStatusReasons.sql",
            "script/createTestUser.sql"
    })
    @Test
    void testUpdateUser() throws Exception {
        executeAndCompare("updateExistUserEmailTest");
    }

    @Test
    void testFullEmpty() throws Exception {
        executeAndCompare("updateAllEmptyTest");
    }

    @Sql(scripts = {
            "script/fillStatus.sql",
            "script/fillStatusReasons.sql",
    })
    @Test
    void testNewUser() throws Exception {
        executeAndCompare("createNewUserTest");
    }

    @Sql(scripts = {
            "script/fillStatus.sql",
            "script/fillStatusReasons.sql",
            "script/createTestUser.sql"
    })
    @Test
    void testNewExistUser() throws Exception {
        executeAndCompare("createExistUserTest");
    }


}
