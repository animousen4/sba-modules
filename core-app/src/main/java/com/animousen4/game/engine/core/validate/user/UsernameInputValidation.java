package com.animousen4.game.engine.core.validate.user;

import com.animousen4.game.engine.core.validate.UserValidation;
import com.animousen4.game.engine.core.validate.ValidationErrorFactory;
import com.animousen4.game.engine.core.validate.regex.ValidationRegistrationRegex;
import com.animousen4.game.engine.core.services.dto.UserDto;
import com.animousen4.game.engine.dto.h1.ValidationError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.animousen4.game.engine.core.values.AppConsts.*;

@Component
public class UsernameInputValidation implements UserValidation {
    @Autowired
    ValidationErrorFactory validationErrorFactory;

    @Autowired
    ValidationRegistrationRegex validationRegex;

    public Optional<ValidationError> validateUserSize(UserDto obj) {
        return obj.getUpdatedUsername().matches(validationRegex.usernameSizeRegex) ?
                Optional.empty() :
                Optional.of(validationErrorFactory.buildError(USERNAME_LENGTH_PROBLEM));
    }

    public Optional<ValidationError> validateUserSymbols(UserDto obj) {
        return obj.getUpdatedUsername().matches(validationRegex.usernameSymbolsRegex) ?
                Optional.empty() :
                Optional.of(validationErrorFactory.buildError(USERNAME_SYMBOLS_PROBLEM));
    }

    public Optional<ValidationError> validateUserMail(UserDto obj) {
        return obj.getUpdatedUsername().matches(validationRegex.mailRegex) ?
                Optional.empty() :
                Optional.of(validationErrorFactory.buildError(WRONG_EMAIL_TYPE));
    }

    @Override
    public List<ValidationError> validateList(UserDto obj) {
        ArrayList<Optional<ValidationError>> res = new ArrayList<>();

        if (obj != null && obj.getUpdatedUsername() != null) {
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
