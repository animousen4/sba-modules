package com.animousen4.game.engine.rest.v1;

import com.animousen4.game.engine.RootUserLoader;
import com.animousen4.game.engine.rest.common.AbstractControllerBootTest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserIntegrationControllerTest extends AbstractControllerBootTest {

    @Autowired
    private RootUserLoader userLoader;
    @Override
    protected String getBaseUrl() {
        return "/api/v1/user/createOrUpdateUser";
    }

    @Override
    protected String getJsonLocation() {
        return "rest/v1/user";
    }


    @Override
    protected String getJwtToken() {
        return userLoader.getRootUserJwt().getJwt();
    }

    @Test
    @Sql(statements = "INSERT INTO users (username, email, status_id, password)\n" +
            "VALUES ('testUser', 'email@example.com', 1, 'pss');")
    void testUpdateUser() throws Exception {
        executeAndCompare("updateExistUserEmailTest");
    }

    @Test
    void testFullEmpty() throws Exception {
        executeAndCompare("updateAllEmptyTest");
    }



    @Test
    @Sql(statements = "INSERT INTO users (username, email, status_id, password)\n" +
            "VALUES ('testUserExist', 'email@example.com', 1, 'pss');")
    void testNewExistUser() throws Exception {
        executeAndCompare("createExistUserTest");
    }


}
