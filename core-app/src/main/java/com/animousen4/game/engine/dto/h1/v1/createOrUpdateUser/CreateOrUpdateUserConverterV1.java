package com.animousen4.game.engine.dto.h1.v1.createOrUpdateUser;

import com.animousen4.game.engine.core.api.command.CreateOrUpdateUserCommand;
import com.animousen4.game.engine.core.api.model.user.UserModel;
import com.animousen4.game.engine.core.api.result.CreateOrUpdateUserResult;
import com.animousen4.game.engine.core.services.dto.UserDto;
import com.animousen4.game.engine.dto.h1.AbstractConverter;
import org.springframework.stereotype.Component;

@Component
public class CreateOrUpdateUserConverterV1 implements
        AbstractConverter<
                CreateOrUpdateUserRequestV1,
                CreateOrUpdateUserCommand,
                CreateOrUpdateUserResponseV1,
                CreateOrUpdateUserResult
                > {

    @Override
    public CreateOrUpdateUserCommand buildCommand(CreateOrUpdateUserRequestV1 request) {
        UserDto user = request.getUser();

        return CreateOrUpdateUserCommand.builder()
                .userModel(
                        user == null ?
                                UserModel.builder().build() :
                        UserModel.builder()
                                .updatedUsername(user.getUpdatedUsername())
                                .username(user.getUsername())
                                .email(user.getEmail())
                                .statusId(user.getStatusId())
                                .statusReasonId(user.getStatusReasonId())
                                .build()
                )
                .build();

    }

    @Override
    public CreateOrUpdateUserResponseV1 buildResponse(CreateOrUpdateUserResult result) {
        return CreateOrUpdateUserResponseV1.builder()
                .errors(result.getValidationErrors())
                .build();
    }
}
