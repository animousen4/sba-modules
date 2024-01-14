package com.animousen4.game.engine.core.validate.validator;

import com.animousen4.game.engine.core.validate.AbstractValidation;
import com.animousen4.game.engine.dto.h1.ValidationError;
import lombok.extern.log4j.Log4j2;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

abstract public class AbstractValidator
        <ENTITY, T extends AbstractValidation<ENTITY>> implements AbstractValidatorInterface<ENTITY>{
    protected abstract List<T> validationComponentsList();
    @Override
    public List<ValidationError> validate(ENTITY entity) {
        if (validationComponentsList() == null) {
            return List.of();
        }
        List<ValidationError> singleErrors = collectSingleErrors(entity);
        List<ValidationError> listErrors = collectListErrors(entity);
        return concatenateLists(singleErrors, listErrors);
    }

    List<ValidationError> collectSingleErrors(ENTITY entity) {
        return validationComponentsList().stream()
                .map(validation -> validation.validate(entity))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
    }

    List<ValidationError> collectListErrors(ENTITY entity){
        return validationComponentsList().stream()
                .map(validation -> validation.validateList(entity))
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
