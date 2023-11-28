package com.animousen4.game.engine.rest;

import com.animousen4.game.engine.core.services.UserService;
import com.animousen4.game.engine.core.underwriting.res.UserCredsResult;
import com.animousen4.game.engine.dto.v1.CreateOrUpdateUserRequestV1;
import com.animousen4.game.engine.dto.v1.CreateOrUpdateUserResponseV1;
import com.animousen4.game.engine.dto.v1.SolvePositionRequestV1;
import com.animousen4.game.engine.dto.v1.SolvePositionResponseV1;
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
    @PostMapping(
            path="/createOrUpdateUser",
            consumes = "application/json",
            produces = "application/json"
    )
    public CreateOrUpdateUserResponseV1 createOrUpdateUser(
            @RequestBody CreateOrUpdateUserRequestV1 request
    ) {
        //return new CreateOrUpdateUserResponseV1();
        return buildResponseCreateOrUpdate(request);
    }

    public CreateOrUpdateUserResponseV1 buildResponseCreateOrUpdate(CreateOrUpdateUserRequestV1 request) {
        UserCredsResult result = userService.getUserCreds(request.getUser());

        return result.hasErrors() ?
                new CreateOrUpdateUserResponseV1(result.getErrorList()) :
                CreateOrUpdateUserResponseV1.builder()
                        .status(result.getUserCreds())
                        .build();

    }
}
