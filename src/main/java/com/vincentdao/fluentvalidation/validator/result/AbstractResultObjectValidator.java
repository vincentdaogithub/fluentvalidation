package com.vincentdao.fluentvalidation.validator.result;

import com.vincentdao.fluentvalidation.FluentValidationProcess;
import com.vincentdao.fluentvalidation.validator.AbstractValidatorStrategy;
import com.vincentdao.fluentvalidation.validator.result.implementation.object.ResultEqualValidatorStrategy;
import com.vincentdao.fluentvalidation.validator.result.implementation.object.ResultInstanceOfValidatorStrategy;
import com.vincentdao.fluentvalidation.validator.result.implementation.object.ResultNotEqualValidatorStrategy;
import com.vincentdao.fluentvalidation.validator.result.implementation.object.ResultNotInstanceOfValidatorStrategy;
import com.vincentdao.fluentvalidation.validator.result.implementation.object.ResultNotNullValidatorStrategy;
import com.vincentdao.fluentvalidation.validator.result.implementation.object.ResultNullValidatorStrategy;
import com.vincentdao.result.NoValue;
import com.vincentdao.result.Result;

public abstract class AbstractResultObjectValidator<S extends AbstractResultObjectValidator<S, V>, V>
        extends AbstractResultValidator<S, V> {

    protected AbstractResultObjectValidator(V value, FluentValidationProcess parent, Result<NoValue> result) {
        super(value, parent, result);
    }

    public AbstractResultValidatorStrategy<ResultNullValidatorStrategy<S, V>, S, V> toBeNull() {
        return new ResultNullValidatorStrategy<>(value(), self(), result());
    }

    public AbstractResultValidatorStrategy<ResultNotNullValidatorStrategy<S, V>, S, V> toBeNotNull() {
        return new ResultNotNullValidatorStrategy<>(value(), self(), result());
    }

    public <O> AbstractResultValidatorStrategy<ResultEqualValidatorStrategy<S, V, O>, S, V> toBeEqualTo(O other) {
        return new ResultEqualValidatorStrategy<>(value(), self(), result(), other);
    }

    public <O> AbstractResultValidatorStrategy<ResultNotEqualValidatorStrategy<S, V, O>, S, V> toBeNotEqualTo(O other) {
        return new ResultNotEqualValidatorStrategy<>(value(), self(), result(), other);
    }

    public AbstractValidatorStrategy<ResultInstanceOfValidatorStrategy<S, V>, S, V> toBeInstanceOf(Class<?> clazz) {
        return new ResultInstanceOfValidatorStrategy<>(value(), self(), result(), clazz);
    }

    public AbstractValidatorStrategy<ResultNotInstanceOfValidatorStrategy<S, V>, S, V> toBeNotInstanceOf(Class<?> clazz) {
        return new ResultNotInstanceOfValidatorStrategy<>(value(), self(), result(), clazz);
    }
}
