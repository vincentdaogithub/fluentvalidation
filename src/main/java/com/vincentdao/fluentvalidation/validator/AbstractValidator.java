package com.vincentdao.fluentvalidation.validator;

import com.vincentdao.fluentvalidation.FluentProcess;

public abstract class AbstractValidator<S extends AbstractValidator<S, P, V>, P extends FluentProcess, V>
        extends AbstractFluent<S, V> {

    private static final String DEFAULT_NAME = "value";

    private final P parent;
    private String name;

    protected AbstractValidator(V value, P parent) {
        super(value);
        this.parent = parent;
        this.name = DEFAULT_NAME;
    }

    public final S withName(String name) {
        if (name == null) {
            throw new NullPointerException("Name for value to be validated must be defined.");
        }
        this.name = name;
        return self();
    }

    protected final String name() {
        return name;
    }

    public final P next() {
        return parent;
    }
}
