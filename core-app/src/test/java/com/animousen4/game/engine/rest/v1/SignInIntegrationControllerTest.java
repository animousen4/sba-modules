package com.animousen4.game.engine.rest.v1;

import com.animousen4.game.engine.RootUserLoader;
import com.animousen4.game.engine.core.api.result.JwtResult;
import com.animousen4.game.engine.rest.common.AbstractControllerBootTest;
import com.animousen4.game.engine.security.service.JwtService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class SignInIntegrationControllerTest extends AbstractControllerBootTest {

    @Autowired
    private RootUserLoader userLoader;

    @Autowired
    private JwtService jwtService;
    @Override
    protected String getBaseUrl() {
        return "/internal/api/v1/auth/signIn";
    }

    @Override
    protected String getJsonLocation() {
        return "rest/v1/auth/signIn";
    }


    @Override
    protected String getJwtToken() {
        return userLoader.getRootUserJwt().getJwt();
    }


    @Test
    void testSignUpAllOk() throws Exception {
        JwtResult res = execute("signInAllOk", status().isOk(), JwtResult.class);

        System.out.println(res.getJwt());
        var username = jwtService.extractUserName(res.getJwt());
        var roles = jwtService.extractRoles(res.getJwt());

        assertEquals("root", username);
        assertEquals(3, roles.size());

    }

    @Test
    void testSignMandatoryOneMissing() throws Exception {
        JwtResult res = execute("signInOneMandatoryMissing", status().isOk(), JwtResult.class);

        assertEquals(1, res.getValidationErrors().size());

    }
    @Test
    void testSignMandatoryTwoMissing() throws Exception {
        JwtResult res = execute("signInTwoMandatoryMissing", status().isOk(), JwtResult.class);

        assertEquals(2, res.getValidationErrors().size());

    }

    @Test
    void testSignInvalidLoginOrPass() throws Exception {
        executeAndCompare("signInInvalidLoginOrPass");

    }

}
