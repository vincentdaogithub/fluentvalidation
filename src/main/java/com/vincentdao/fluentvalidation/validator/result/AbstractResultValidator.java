package com.vincentdao.fluentvalidation.validator.result;

import com.vincentdao.fluentvalidation.FluentValidationProcess;
import com.vincentdao.fluentvalidation.validator.AbstractValidator;
import com.vincentdao.result.NoValue;
import com.vincentdao.result.Result;

public abstract class AbstractResultValidator<S extends AbstractResultValidator<S, V>, V>
        extends AbstractValidator<S, FluentValidationProcess, V> {

    private final Result<NoValue> result;

    protected AbstractResultValidator(V value, FluentValidationProcess parent, Result<NoValue> result) {
        super(value, parent);
        this.result = result;
    }

    protected Result<NoValue> result() {
        return result;
    }
}
