package com.animousen4.game.engine.core.services;

import com.animousen4.game.engine.core.api.command.CreateOrUpdateUserCommand;
import com.animousen4.game.engine.core.api.command.GetUserInfoCommand;
import com.animousen4.game.engine.core.api.model.user.UserModel;
import com.animousen4.game.engine.core.api.result.CreateOrUpdateUserResult;
import com.animousen4.game.engine.core.api.result.GetUserInfoResult;
import com.animousen4.game.engine.core.dao.UserDao;
import com.animousen4.game.engine.core.repositories.UserRepository;
import com.animousen4.game.engine.core.repositories.entities.UserEntity;
import com.animousen4.game.engine.core.services.dto.UserInfoDto;
import com.animousen4.game.engine.core.underwriting.res.UserCredsResult;
import com.animousen4.game.engine.core.util.Placeholder;
import com.animousen4.game.engine.core.validations.UserValidator;
import com.animousen4.game.engine.core.validations.ValidationErrorFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.animousen4.game.engine.core.consts.AppConsts.*;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserValidator validator;

    @Autowired
    ValidationErrorFactory validationErrorFactory;

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserDao userDao;

    @Autowired
    TimestampService timestampService;

    @Override
    public GetUserInfoResult getUserInfo(GetUserInfoCommand command) {
        UserEntity ent = userRepository.findUserEntityByUsername(command.getUsername());

        if (ent != null)
            return getUser(command, ent);
        else
            return notFoundUser(command);

    }

    GetUserInfoResult notFoundUser(GetUserInfoCommand command) {
        return GetUserInfoResult.builder()
                .validationErrors(List.of(validationErrorFactory.buildError(
                        USER_NOT_FOUND,
                        new Placeholder(USERNAME, command.getUsername() )
                )))
                .build();
    }

    GetUserInfoResult getUser(GetUserInfoCommand command, UserEntity ent) {
        return GetUserInfoResult.builder()
                .userModel(
                        UserModel.builder()
                                .username(ent.getUsername())
                                .email(ent.getEmail())
                                .statusId(ent.getStatusId())
                                .statusReasonId(ent.getStatusReasonId())
                                .build())
                .build();
    }

    @Override
    public CreateOrUpdateUserResult createOrUpdateUser(CreateOrUpdateUserCommand userCommand) {
        UserModel requestUserModel = userCommand.getUserModel();
        UserEntity ent = userDao.getUserByUsername(requestUserModel.getUsername());

        if (ent == null)
            if (requestUserModel.getUpdatedUsername() == null)
                return notFoundUser(requestUserModel);
            else
                return createUser(requestUserModel);
        else
            return updateUser(requestUserModel, ent);

    }

    private CreateOrUpdateUserResult updateUser(UserModel requestUserModel, UserEntity ent) {
        userDao.updateUserById(
                ent
                    .withEmail(requestUserModel.getEmail())
                    .withUsername(requestUserModel.getUpdatedUsername() == null ? ent.getUsername() :requestUserModel.getUpdatedUsername())

        );
        return CreateOrUpdateUserResult.builder()

                .build();
    }

    private CreateOrUpdateUserResult createUser(UserModel requestUserModel) {
        UserEntity existEntity = userDao.getUserByUsername(requestUserModel.getUpdatedUsername());
        if (existEntity == null) {
            userDao.saveUser(
                    UserEntity.builder()
                            .username(requestUserModel.getUpdatedUsername())
                            .registrationDate(timestampService.getCurrentTime())
                            .email(requestUserModel.getEmail())
                            .statusId(1L)
                            .build()
            );
            return CreateOrUpdateUserResult.builder()
                    .build();
        }
        else
            return CreateOrUpdateUserResult.builder()
                    .validationErrors(
                            List.of(validationErrorFactory.buildError(
                                    USER_EXISTS,
                                    new Placeholder(USERNAME, existEntity.getUsername())
                                    )))
                    .build();
    }

    private CreateOrUpdateUserResult notFoundUser(UserModel requestUserModel) {
        return CreateOrUpdateUserResult.builder()
                .validationErrors(
                        List.of(validationErrorFactory.buildError(
                                USER_NOT_FOUND,
                                new Placeholder(USERNAME, requestUserModel.getUsername())
                        ))
                )
                .build();
    }

}
