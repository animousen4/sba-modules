package com.animousen4.game.engine.testcontainers;

import com.animousen4.game.engine.rest.common.AbstractTestcontainersConnections;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ContainersRunningTest extends AbstractTestcontainersConnections {

    @Test
    void postgresRunningTest() {
        assertTrue(postgreSQLContainer.isRunning());
    }

    @Test
    void redisRunningTest() {
        assertTrue(redisContainer.isRunning());
    }
}
