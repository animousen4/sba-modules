package com.animousen4.game.engine.dto.h1.v1.getUserInfo;

import com.animousen4.game.engine.core.api.command.GetUserInfoCommand;
import com.animousen4.game.engine.core.api.result.GetUserInfoResult;
import com.animousen4.game.engine.core.services.dto.UserInfoDto;
import com.animousen4.game.engine.dto.h1.AbstractConverter;
import org.springframework.stereotype.Component;

@Component
public class GetUserInfoConverterV1 implements AbstractConverter<
        GetUserInfoRequestV1,
        GetUserInfoCommand,
        GetUserInfoResponseV1,
        GetUserInfoResult
        > {
    @Override
    public GetUserInfoCommand buildCommand(GetUserInfoRequestV1 request) {
        return GetUserInfoCommand.builder()
                .username(request.getUsername())
                .build();
    }

    @Override
    public GetUserInfoResponseV1 buildResponse(GetUserInfoResult result) {
        return result.hasErrors()
                ? buildFailedResponse(result)
                : buildSuccessfulResponse(result);
    }

    public GetUserInfoResponseV1 buildSuccessfulResponse(GetUserInfoResult result) {
        return GetUserInfoResponseV1.builder()
                .info(
                        UserInfoDto.builder()
                                .username(result.getUserModel().getUsername())
                                .email(result.getUserModel().getEmail())
                                .status(result.getUserModel().getStatus())
                                .build()
                )
                .build();
    }

    public GetUserInfoResponseV1 buildFailedResponse(GetUserInfoResult result) {
        return GetUserInfoResponseV1.builder()
                .errors(result.getValidationErrors())
                .build();
    }
}
