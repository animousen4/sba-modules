package com.animousen4.game.engine.core.validate.chaining;

import com.animousen4.game.engine.dto.ValidationError;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor

public class ValidationChaining {
    private final List<ValidationError> parentErrors;

    private final List<ValidationError> errors;

    private final List<ValidationError> childErrors;

    private final ValidationChaining parent;
    ValidationChaining() {
        errors = new ArrayList<>();
        parentErrors = new ArrayList<>();
        childErrors = new ArrayList<>();
        parent = null;
    }

    ValidationChaining(ValidationChaining parent) {
        errors = new ArrayList<>();
        childErrors = new ArrayList<>();
        parentErrors = new ArrayList<>(parent.errors);
        this.parent = parent;
    }

    public static ValidationChaining start() {
        return new ValidationChaining();
    }
    public <T> ValidationChaining goNextIfOk(FuncGetter<T> getter, FuncValidator<T> validator) {
        if (errors.isEmpty() && parentErrors.isEmpty())
            return goNext(getter, validator);
        return this;
    }

    public ValidationChaining startParallel() {
        return new ValidationChaining(this);
    }

    public ValidationChaining endParallel() {
        assert (parent != null);

        parent.addErrors(errors);
        return parent;
    }

    public <T> ValidationChaining goNext(FuncGetter<T> getter, FuncValidator<T> validator) {
        validator.validate(getter.get()).ifPresent(errors::add);

        return this;
    }

    private void addErrors(List<ValidationError> errors) {
        this.childErrors.addAll(errors);
    }

    public List<ValidationError> validate() {
        List<ValidationError> totalErrors = new ArrayList<>();
        totalErrors.addAll(errors);
        totalErrors.addAll(childErrors);

        return totalErrors;
    }

}
