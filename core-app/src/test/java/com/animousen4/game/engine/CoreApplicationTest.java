package com.animousen4.game.engine;


import org.junit.ClassRule;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.testcontainers.containers.PostgreSQLContainer;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CoreApplication.class)
@ActiveProfiles({"tc", "tc-auto"})
class CoreApplicationTest {

    @ClassRule
    public static PostgreSQLContainer<PostgresContainerSettings> postgreSQLContainer =
            PostgresContainerSettings.getInstance(TestContainerGameEngineConstants.INIT_DB_SCRIPT_PATH);

    //tests

    @BeforeAll()
    static void beforeAll() {
        postgreSQLContainer.start();
    }

    @AfterAll()
    static void afterAll() {
        postgreSQLContainer.stop();
    }

    @Test
    void contextLoadsTest() {

    }
}