package com.animousen4.game.engine;

import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.testcontainers.containers.PostgreSQLContainer;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = GameEngineApplication.class)
@ActiveProfiles({"tc", "tc-auto"})
public class GameEngineAppStartTest  {

    @ClassRule
    public static PostgreSQLContainer<GameEngineContainerTest> postgreSQLContainer = GameEngineContainerTest.getInstance();

    //tests

    @Test
    void contextStartupWithContainersTest() {

    }
}