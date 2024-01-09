package com.animousen4.game.engine.core.validations;

import com.animousen4.game.engine.dto.ValidationError;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

abstract public class AbstractValidator
        <E, T extends AbstractValidation<E>> implements AbstractValidatorInterface<E>{
    abstract List<T> validationComponentsList();
    @Override
    public List<ValidationError> validate(E entity) {
        List<ValidationError> singleErrors = collectSingleErrors(entity);
        List<ValidationError> listErrors = collectListErrors(entity);
        return concatenateLists(singleErrors, listErrors);
    }

    List<ValidationError> collectSingleErrors(E entity) {
        return validationComponentsList().stream()
                .map(validation -> validation.validate(entity))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
    }

    List<ValidationError> collectListErrors(E entity){
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
