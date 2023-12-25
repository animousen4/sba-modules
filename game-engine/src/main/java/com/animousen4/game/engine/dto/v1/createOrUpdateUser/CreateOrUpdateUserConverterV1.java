package com.animousen4.game.engine.dto.v1.createOrUpdateUser;

import com.animousen4.game.engine.core.api.command.CoreCommand;
import com.animousen4.game.engine.core.api.command.CreateOrUpdateUserCommand;
import com.animousen4.game.engine.core.api.model.user.UserModel;
import com.animousen4.game.engine.core.api.result.CoreResult;
import com.animousen4.game.engine.core.api.result.CreateOrUpdateUserResult;
import com.animousen4.game.engine.core.services.dto.UserDto;
import com.animousen4.game.engine.dto.AbstractConverter;
import com.animousen4.game.engine.dto.CoreRequest;
import com.animousen4.game.engine.dto.CoreResponse;
import org.springframework.stereotype.Component;

@Component
public class CreateOrUpdateUserConverterV1 extends
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
                                .id(user.getId())
                                .username(user.getUsername())
                                .oldUsername(user.getOldUsername())
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
