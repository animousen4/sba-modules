package com.animousen4.game.engine.rest.common;

import com.animousen4.game.engine.PostgresContainerSettings;
import com.animousen4.game.engine.RedisContainerSettings;
import com.animousen4.game.engine.TestContainerGameEngineConstants;
import org.junit.ClassRule;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;
import org.testcontainers.containers.PostgreSQLContainer;

import static com.animousen4.game.engine.TestContainerConstants.REDIS_TEST_PORT;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static uk.org.webcompere.modelassert.json.JsonAssertions.assertJson;

public abstract class AbstractIntegrationControllerTest {

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

    @Autowired
    private MockMvc mockMvc;

    @Autowired private JsonFileReader jsonFileReader;

    abstract protected String getBaseUrl();

    abstract protected String getJsonLocation();

    protected void executeAndCompare(String jsonFolder) throws Exception {
        executeAndCompare(jsonFolder, status().isOk());
    }
    protected void executeAndCompare(String jsonFolder, ResultMatcher expectedResult) throws Exception {
        executeAndCompare(
                getJsonLocation().concat("/").concat(jsonFolder).concat("/request.json"),
                getJsonLocation().concat("/").concat(jsonFolder).concat("/response.json"),
                expectedResult
        );
    }

    protected void executeAndCompare(String jsonRequestFilePath,
                                     String jsonResponseFilePath, ResultMatcher expectedResult) throws Exception {
        String jsonRequest = jsonFileReader.readJsonFromFile(jsonRequestFilePath);

        MvcResult result = mockMvc.perform(post(getBaseUrl())
                        .content(jsonRequest)
                        .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE))
                .andExpect(expectedResult)
                .andReturn();

        String responseBodyContent = result.getResponse().getContentAsString();

        String jsonResponse = jsonFileReader.readJsonFromFile(jsonResponseFilePath);

        assertJson(responseBodyContent)
                .where()
                .keysInAnyOrder()
                .arrayInAnyOrder()
                .isEqualTo(jsonResponse);
    }
}
