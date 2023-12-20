package com.animousen4.game.engine.core.validations.user;

import com.animousen4.game.engine.core.validations.UserValidation;
import com.animousen4.game.engine.core.validations.ValidationErrorFactory;
import com.animousen4.game.engine.core.services.regex.ValidationRegex;
import com.animousen4.game.engine.core.services.dto.UserDto;
import com.animousen4.game.engine.dto.ValidationError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.animousen4.game.engine.core.consts.AppConsts.*;

@Component
public class UsernameInputValidation implements UserValidation {
    @Autowired
    ValidationErrorFactory validationErrorFactory;

    @Autowired
    ValidationRegex validationRegex;
    @Override
    public Optional<ValidationError> validate(UserDto obj) {
        return Optional.empty();
    }

    public Optional<ValidationError> validateUserSize(UserDto obj) {
        return obj.getUsername().matches(validationRegex.usernameSizeRegex) ?
                Optional.empty() :
                Optional.of(validationErrorFactory.buildError(USERNAME_LENGTH_PROBLEM));
    }

    public Optional<ValidationError> validateUserSymbols(UserDto obj) {
        return obj.getUsername().matches(validationRegex.usernameSymbolsRegex) ?
                Optional.empty() :
                Optional.of(validationErrorFactory.buildError(USERNAME_SYMBOLS_PROBLEM));
    }

    public Optional<ValidationError> validateUserMail(UserDto obj) {
        return obj.getUsername().matches(validationRegex.mailRegex) ?
                Optional.empty() :
                Optional.of(validationErrorFactory.buildError(WRONG_EMAIL_TYPE));
    }

    @Override
    public List<ValidationError> validateList(UserDto obj) {
        ArrayList<Optional<ValidationError>> res = new ArrayList<>();

        if (obj != null && obj.getUsername() != null) {
            res.add(validateUserSize(obj));
            res.add(validateUserSymbols(obj));
            res.add(validateUserMail(obj));
        }
        return res.stream()
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());


    }
}
