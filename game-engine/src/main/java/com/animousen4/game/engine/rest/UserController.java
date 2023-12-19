package com.animousen4.game.engine.rest;

import com.animousen4.game.engine.core.logger.RequestLogger;
import com.animousen4.game.engine.core.services.UserService;
import com.animousen4.game.engine.core.underwriting.res.UserCredsResult;
import com.animousen4.game.engine.dto.v1.GetUserCreds;
import com.animousen4.game.engine.dto.v1.CreateOrUpdateUserResponseV1;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    RequestLogger requestLogger;
    @PostMapping(
            path="/getUserInfo",
            consumes = "application/json",
            produces = "application/json"
    )
    public CreateOrUpdateUserResponseV1 createOrUpdateUser(
            @RequestBody GetUserCreds request
    ) {
        //return new CreateOrUpdateUserResponseV1();
        return buildResponseCreateOrUpdate(request);
    }

    public CreateOrUpdateUserResponseV1 buildResponseCreateOrUpdate(GetUserCreds request) {
        UserCredsResult result = userService.getUserCredentials(request.getUserId());
        requestLogger.logRequest(request);
        return result.hasErrors() ?
                new CreateOrUpdateUserResponseV1(result.getErrorList()) :
                CreateOrUpdateUserResponseV1.builder()
                        .status(result.getUserCreds())
                        .build();

    }
}
