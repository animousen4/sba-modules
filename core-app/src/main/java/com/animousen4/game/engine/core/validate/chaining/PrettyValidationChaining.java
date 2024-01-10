package com.animousen4.game.engine.core.validate.chaining;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

@AllArgsConstructor
public class PrettyValidationChaining<V> {

    private final List<V> parentErrors;

    private final List<V> errors;

    private final List<V> childErrors;

    private final PrettyValidationChaining<V> parent;
    protected PrettyValidationChaining() {
        errors = new ArrayList<>();
        parentErrors = new ArrayList<>();
        childErrors = new ArrayList<>();
        parent = null;
    }


    protected PrettyValidationChaining(PrettyValidationChaining<V> parent) {
        errors = new ArrayList<>();
        childErrors = new ArrayList<>();
        parentErrors = new ArrayList<>(parent.errors);
        this.parent = parent;
    }


    public PrettyValidationChaining<V> parallel(Function<PrettyValidationChaining<V>, PrettyValidationChaining<V>> function) {
        if (errors.isEmpty())
            this.addErrors(
                    function.apply(
                            new PrettyValidationChaining<>(this)
                    ).errors);
        return this;
    }


    public <T> PrettyValidationChaining<V> go(FuncGetter<T> getter, FuncValidator<V, T> validator) {
        if (errors.isEmpty() && parentErrors.isEmpty())
            validator.validate(getter.get()).ifPresent(errors::add);
        return this;
    }

    public <T> PrettyValidationChaining<V> goList(FuncGetter<T> getter, FuncValidatorList<V, T> validator) {
        if (errors.isEmpty() && parentErrors.isEmpty()) {
            var validatedErrors = validator.validate(getter.get());

            if (validatedErrors != null) {
                errors.addAll(validatedErrors);
            }
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
