package com.animousen4.game.engine.rest.common;

import com.animousen4.game.engine.PostgresContainerSettings;
import com.animousen4.game.engine.RedisContainerSettings;
import com.animousen4.game.engine.TestContainerGameEngineConstants;
import org.junit.ClassRule;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;

import static com.animousen4.game.engine.TestContainerConstants.REDIS_TEST_PORT;

public abstract class AbstractTestcontainersConnections {
    @ClassRule
    public static PostgreSQLContainer<PostgresContainerSettings> postgreSQLContainer =
            PostgresContainerSettings.getInstance(TestContainerGameEngineConstants.INIT_DB_SCRIPT_PATH);


    @ClassRule
    public static RedisContainerSettings redisContainer = RedisContainerSettings.getInstance();
    //tests

    @DynamicPropertySource
    private static void registerRedisProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.data.redis.host", redisContainer::getHost);
        registry.add("spring.data.redis.port", () -> redisContainer.getMappedPort(REDIS_TEST_PORT).toString());
    }
    @BeforeAll()
    static void beforeAll() {
        postgreSQLContainer.start();
        redisContainer.start();
    }

    @AfterAll()
    static void afterAll() {
        postgreSQLContainer.stop();
        redisContainer.stop();
    }
}
