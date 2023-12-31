package com.animousen4.game.engine.core.services;

import com.animousen4.game.engine.core.api.command.CreateOrUpdateUserCommand;
import com.animousen4.game.engine.core.api.model.user.UserModel;
import com.animousen4.game.engine.core.api.result.CreateOrUpdateUserResult;
import com.animousen4.game.engine.core.dao.UserDao;
import com.animousen4.game.engine.core.repositories.UserRepository;
import com.animousen4.game.engine.core.repositories.entities.UserEntity;
import com.animousen4.game.engine.core.services.dto.UserCreds;
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
    // Connect to db
    @Override
    public UserCredsResult getUserCredentials(Long id) {

        UserEntity ent = userRepository.findUserEntityById(id);

        if (ent != null) {
            UserCredsResult result =
                    UserCredsResult.builder()
                            .userCreds(
                                    UserCreds.builder()
                                            .id(ent.getId())
                                            .statusId(ent.getStatusId())
                                            .username(ent.getUsername())
                                            .build()

                            )
                            .build();
            return result;
        } else {
            return UserCredsResult.builder()
                    .errorList(List.of(validationErrorFactory.buildError(
                            USER_NOT_FOUND,
                            new Placeholder(USER_ID, id)
                    )))
                    .build();
        }
    }

    @Override
    public CreateOrUpdateUserResult createOrUpdateUser(CreateOrUpdateUserCommand userCommand) {
        UserModel requestUserModel = userCommand.getUserModel();
        UserEntity ent = userDao.getUserByUsername(requestUserModel.getUsername());

        if (ent == null)
            if (requestUserModel.getUsername() == null && requestUserModel.getUpdatedUsername() == null)
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
        userDao.saveUser(
                UserEntity.builder()
                        .username(requestUserModel.getUpdatedUsername())
                        .creatorId(1)
                        .email(requestUserModel.getEmail())
                        .build()
        );
        return CreateOrUpdateUserResult.builder()

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
