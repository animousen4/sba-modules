package com.animousen4.game.engine.core.validate.chaining;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor

public class ValidationChaining<V> {

    private final List<V> parentErrors;

    private final List<V> errors;

    private final List<V> childErrors;

    private final ValidationChaining<V> parent;
    protected ValidationChaining() {
        errors = new ArrayList<>();
        parentErrors = new ArrayList<>();
        childErrors = new ArrayList<>();
        parent = null;
    }


    protected ValidationChaining(ValidationChaining<V> parent) {
        errors = new ArrayList<>();
        childErrors = new ArrayList<>();
        parentErrors = new ArrayList<>(parent.errors);
        this.parent = parent;
    }



    public ValidationChaining<V> startParallel() {
        return new ValidationChaining<>(this);
    }

    public ValidationChaining<V> endParallel() {
        assert (parent != null);

        parent.addErrors(errors);
        return parent;
    }

    public <T> ValidationChaining<V> goIfOk(FuncGetter<T> getter, FuncValidator<V, T> validator) {
        if (errors.isEmpty() && parentErrors.isEmpty())
            return go(getter, validator);
        return this;
    }

    public <T> ValidationChaining<V> go(FuncGetter<T> getter, FuncValidator<V, T> validator) {
        validator.validate(getter.get()).ifPresent(errors::add);

        return this;
    }

    public <T> ValidationChaining<V> goListIfOk(FuncGetter<T> getter, FuncValidatorList<V, T> validator) {
        if (errors.isEmpty() && parentErrors.isEmpty())
            return goList(getter, validator);

        return this;
    }
    public <T> ValidationChaining<V> goList(FuncGetter<T> getter, FuncValidatorList<V, T> validator) {
        var validatedErrors = validator.validate(getter.get());

        if (validatedErrors != null) {
            errors.addAll(validatedErrors);
        }
        return this;
    }

    private void addErrors(List<V> errors) {
        this.childErrors.addAll(errors);
    }

    public List<V> validate() {
        List<V> totalErrors = new ArrayList<>();
        totalErrors.addAll(errors);
        totalErrors.addAll(childErrors);

        return totalErrors;
    }

}
