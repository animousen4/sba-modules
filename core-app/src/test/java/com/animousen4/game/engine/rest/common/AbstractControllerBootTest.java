package com.animousen4.game.engine.rest.common;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import java.io.UnsupportedEncodingException;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static uk.org.webcompere.modelassert.json.JsonAssertions.assertJson;

public abstract class AbstractControllerBootTest extends AbstractTestcontainersConnections{

    ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private MockMvc mockMvc;

    @Autowired private JsonFileReader jsonFileReader;

    abstract protected String getBaseUrl();

    abstract protected String getJsonLocation();

    protected String getJwtToken() {
        return null;
    }
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
    private  <T> T mapJsonTo(String json, Class<T> type) throws JsonProcessingException {
        return mapper.readValue(json, type);
    }
    private  String getResponseBodyContent(String jsonRequest, ResultMatcher expectedResult) throws Exception {

        MockHttpServletRequestBuilder requestBuilder = post(getBaseUrl())
                .content(jsonRequest)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);

        if (getJwtToken() != null) {
            requestBuilder = requestBuilder.header(HttpHeaders.AUTHORIZATION, "Bearer %s".formatted(getJwtToken()));
        }
        MvcResult result = mockMvc.perform(requestBuilder)
                .andExpect(expectedResult)
                .andReturn();

        return result.getResponse().getContentAsString();
    }

    protected <T> T execute(String jsonFolder, ResultMatcher expectedResult, Class<T> type) throws Exception {
        String jsonRequestFilePath = getJsonLocation().concat("/").concat(jsonFolder).concat("/request.json");

        String jsonRequest = jsonFileReader.readJsonFromFile(jsonRequestFilePath);

        String responseBodyContent = getResponseBodyContent(jsonRequest, expectedResult);

        return mapJsonTo(responseBodyContent, type);
    }

    protected void executeAndCompare(String jsonRequestFilePath,
                                     String jsonResponseFilePath, ResultMatcher expectedResult) throws Exception {
        String jsonRequest = jsonFileReader.readJsonFromFile(jsonRequestFilePath);

        String responseBodyContent = getResponseBodyContent(jsonRequest, expectedResult);

        String jsonResponse = jsonFileReader.readJsonFromFile(jsonResponseFilePath);

        assertJson(responseBodyContent)
                .where()
                .keysInAnyOrder()
                .arrayInAnyOrder()
                .isEqualTo(jsonResponse);
    }
}
