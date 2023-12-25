package com.animousen4.game.engine.rest;

import com.animousen4.game.engine.dto.v1.createOrUpdateUser.CreateOrUpdateUserConverterV1;
import com.animousen4.game.engine.logger.RequestLogger;
import com.animousen4.game.engine.core.services.UserService;
import com.animousen4.game.engine.core.underwriting.res.UserCredsResult;
import com.animousen4.game.engine.dto.v1.createOrUpdateUser.CreateOrUpdateUserRequestV1;
import com.animousen4.game.engine.dto.v1.createOrUpdateUser.CreateOrUpdateUserResponseV1;
import com.animousen4.game.engine.dto.v1.getUserInfo.GetUserInfoRequestV1;
import com.animousen4.game.engine.dto.v1.getUserInfo.GetUserInfoResponseV1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(
        value = "/api/user",
        consumes = APPLICATION_JSON_VALUE,
        produces = APPLICATION_JSON_VALUE
)
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    RequestLogger requestLogger;

    @Autowired
    CreateOrUpdateUserConverterV1 userConverterV1;
    @PostMapping(path="/getUserInfo")
    public GetUserInfoResponseV1 getUserInfo(
            @RequestBody GetUserInfoRequestV1 request
    ) {
        return buildResponseGetUserInfo(request);
    }

    @PostMapping(path="/createOrUpdateUser")
    public CreateOrUpdateUserResponseV1 createOrUpdateUser(
            @RequestBody CreateOrUpdateUserRequestV1 request
    ) {
        return buildResponseCreateOrUpdateUser(request);
    }

    public CreateOrUpdateUserResponseV1 buildResponseCreateOrUpdateUser(CreateOrUpdateUserRequestV1 requestV1) {
        var command = userConverterV1.buildCommand(requestV1);
        var result = userService.createOrUpdateUser(command);
        return userConverterV1.buildResponse(result);
    }
    public GetUserInfoResponseV1 buildResponseGetUserInfo(GetUserInfoRequestV1 request) {
        UserCredsResult result = userService.getUserCredentials(request.getUserId());
        requestLogger.logRequest(request);
        return result.hasErrors() ?
                new GetUserInfoResponseV1(result.getErrorList()) :
                GetUserInfoResponseV1.builder()
                        .creds(result.getUserCreds())
                        .build();

    }
}
