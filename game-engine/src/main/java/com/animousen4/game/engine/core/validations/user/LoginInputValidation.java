package com.animousen4.game.engine.core.validations.user;

import com.animousen4.game.engine.core.validations.UserValidation;
import com.animousen4.game.engine.core.validations.ValidationErrorFactory;
import com.animousen4.game.engine.core.validations.regex.ValidationRegex;
import com.animousen4.game.engine.dto.User;
import com.animousen4.game.engine.dto.ValidationError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.animousen4.game.engine.core.consts.AppConsts.*;

@Component
public class LoginInputValidation implements UserValidation {
    @Autowired
    ValidationErrorFactory validationErrorFactory;

    @Autowired
    ValidationRegex validationRegex;
    @Override
    public Optional<ValidationError> validate(User obj) {
        return Optional.empty();
    }

    public Optional<ValidationError> validateUserSize(User obj) {
        return obj.getLogin().matches(validationRegex.usernameSizeRegex) ?
                Optional.empty() :
                Optional.of(validationErrorFactory.buildError(USERNAME_LENGTH_PROBLEM));
    }

    public Optional<ValidationError> validateUserSymbols(User obj) {
        return obj.getLogin().matches(validationRegex.usernameSymbolsRegex) ?
                Optional.empty() :
                Optional.of(validationErrorFactory.buildError(USERNAME_SYMBOLS_PROBLEM));
    }

    public Optional<ValidationError> validateUserMail(User obj) {
        return obj.getLogin().matches(validationRegex.mailRegex) ?
                Optional.empty() :
                Optional.of(validationErrorFactory.buildError(WRONG_EMAIL_TYPE));
    }

    @Override
    public List<ValidationError> validateList(User obj) {
        ArrayList<Optional<ValidationError>> res = new ArrayList<>();

        if (obj != null && obj.getLogin() != null) {
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
