package com.animousen4.game.engine.rest.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static uk.org.webcompere.modelassert.json.JsonAssertions.assertJson;

public abstract class AbstractControllerTest {

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
