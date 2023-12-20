package com.animousen4.game.engine.core.services;

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

import static com.animousen4.game.engine.core.consts.AppConsts.USER_ID;
import static com.animousen4.game.engine.core.consts.AppConsts.USER_NOT_FOUND;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserValidator validator;

    @Autowired
    ValidationErrorFactory validationErrorFactory;

    @Autowired
    UserRepository userRepository;
    // Connect to db
    @Override
    public UserCredsResult getUserCredentials(long id) {

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
}
