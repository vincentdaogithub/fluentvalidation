package com.vincentdao.fluentvalidation.validator.result;

import com.vincentdao.fluentvalidation.validator.AbstractValidatorStrategy;
import com.vincentdao.result.NoValue;
import com.vincentdao.result.Result;

public abstract class AbstractResultValidatorStrategy<
        S extends AbstractResultValidatorStrategy<S, P, V>,
        P extends AbstractResultValidator<P, V>,
        V> extends AbstractValidatorStrategy<S, P, V> {

    private final Result<NoValue> result;

    protected AbstractResultValidatorStrategy(V value, P parentValidator, Result<NoValue> result) {
        super(value, parentValidator);
        this.result = result;
    }

    protected Result<NoValue> result() {
        return result;
    }
}
