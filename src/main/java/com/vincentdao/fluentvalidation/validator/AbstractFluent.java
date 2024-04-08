package com.vincentdao.fluentvalidation.validator;

public abstract class AbstractFluent<S extends AbstractFluent<S, V>, V> {

    private final V value;

    protected AbstractFluent(V value) {
        this.value = value;
    }

    @SuppressWarnings("unchecked")
    protected final S self() {
        return (S) this;
    }

    protected final V value() {
        return value;
    }
}
