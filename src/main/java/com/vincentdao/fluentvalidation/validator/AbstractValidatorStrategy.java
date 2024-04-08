package com.vincentdao.fluentvalidation.validator;

import com.vincentdao.fluentvalidation.FluentProcess;

public abstract class AbstractValidatorStrategy<
        S extends AbstractValidatorStrategy<S, P, V>,
        P extends AbstractValidator<P, ? extends FluentProcess, V>,
        V> extends AbstractFluent<S, V> {

    private final P parentValidator;
    private String message;

    protected AbstractValidatorStrategy(V value, P parentValidator) {
        super(value);
        this.parentValidator = parentValidator;
    }

    protected abstract void validate();

    protected abstract String reason();

    public S withMessage(String message) {
        if (message == null) {
            throw new NullPointerException("Message for validator must be defined.");
        }
        this.message = message;
        return self();
    }

    protected final String message() {
        return ((message == null) ? ValidatorMessageBuilder.buildDefault(parentValidator.name(), reason()) : message);
    }

    public final P and() {
        validate();
        return parentValidator;
    }
}
