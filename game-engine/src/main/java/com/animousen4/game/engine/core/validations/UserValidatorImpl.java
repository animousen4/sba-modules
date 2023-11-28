package com.animousen4.game.engine.core.validations;

import com.animousen4.game.engine.dto.User;
import com.animousen4.game.engine.dto.ValidationError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
class UserValidatorImpl implements UserValidator{

    @Autowired
    List<UserValidation> userValidationList;
    @Override
    public List<ValidationError> validate(User user) {
        List<ValidationError> singleErrors = collectSingleErrors(user);
        List<ValidationError> listErrors = collectListErrors(user);
        return concatenateLists(singleErrors, listErrors);
    }

    List<ValidationError> collectSingleErrors(User user) {
        return userValidationList.stream()
                .map(validation -> validation.validate(user))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
    }

    List<ValidationError> collectListErrors(User user){
        return userValidationList.stream()
                .map(validation -> validation.validateList(user))
                .filter(Objects::nonNull)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    List<ValidationError> concatenateLists(List<ValidationError> singleErrors,
                                              List<ValidationError> listErrors) {
        return Stream.concat(singleErrors.stream(), listErrors.stream())
                .collect(Collectors.toList());
    }
}
