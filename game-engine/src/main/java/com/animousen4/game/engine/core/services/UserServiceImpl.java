package com.animousen4.game.engine.core.services;

import com.animousen4.game.engine.core.services.dto.UserCreds;
import com.animousen4.game.engine.core.underwriting.res.UserCredsResult;
import com.animousen4.game.engine.core.validations.UserValidation;
import com.animousen4.game.engine.core.validations.UserValidator;
import com.animousen4.game.engine.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserValidator validator;
    // Connect to db
    @Override
    public UserCredsResult getUserCreds(User user) {
        var errors = validator.validate(user);
        if (errors.isEmpty())
            return UserCredsResult.builder()
                .userCreds(UserCreds.builder()
                        .id(user.getId())
                        .username(user.getLogin())
                        .build())
                .build();
        return UserCredsResult.builder()
                .errorList(errors)
                .build();
    }
}
