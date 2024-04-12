package com.vincentdao.fluentvalidation.validator.result;

import com.vincentdao.fluentvalidation.FluentValidationProcess;
import com.vincentdao.fluentvalidation.validator.result.implementation.number.ResultNumberBetweenValidatorStrategy;
import com.vincentdao.fluentvalidation.validator.result.implementation.number.ResultNumberGreaterThanOrEqualValidatorStrategy;
import com.vincentdao.fluentvalidation.validator.result.implementation.number.ResultNumberGreaterThanValidatorStrategy;
import com.vincentdao.fluentvalidation.validator.result.implementation.number.ResultNumberLessThanOrEqualValidatorStrategy;
import com.vincentdao.fluentvalidation.validator.result.implementation.number.ResultNumberLessThanValidatorStrategy;
import com.vincentdao.result.NoValue;
import com.vincentdao.result.Result;

public abstract class AbstractResultNumberValidator<S extends AbstractResultNumberValidator<S, V>, V extends Number & Comparable<V>>
        extends AbstractResultObjectValidator<S, V> {

    protected AbstractResultNumberValidator(V value, FluentValidationProcess parent, Result<NoValue> result) {
        super(value, parent, result);
    }

    public AbstractResultValidatorStrategy<ResultNumberLessThanValidatorStrategy<S, V>, S, V> toBeLessThan(V other) {
        return new ResultNumberLessThanValidatorStrategy<>(value(), self(), result(), other);
    }

    public AbstractResultValidatorStrategy<ResultNumberGreaterThanValidatorStrategy<S, V>, S, V> toBeGreaterThan(
            V other) {
        return new ResultNumberGreaterThanValidatorStrategy<>(value(), self(), result(), other);
    }

    public AbstractResultValidatorStrategy<ResultNumberLessThanOrEqualValidatorStrategy<S, V>, S, V> toBeLessThanOrEqual(
            V other) {
        return new ResultNumberLessThanOrEqualValidatorStrategy<>(value(), self(), result(), other);
    }

    public AbstractResultValidatorStrategy<ResultNumberGreaterThanOrEqualValidatorStrategy<S, V>, S, V> toBeGreaterThanOrEqual(
            V other) {
        return new ResultNumberGreaterThanOrEqualValidatorStrategy<>(value(), self(), result(), other);
    }

    public AbstractResultValidatorStrategy<ResultNumberBetweenValidatorStrategy<S, V>, S, V> toBeBetween(
            V start, V end) {
        return new ResultNumberBetweenValidatorStrategy<>(value(), self(), result(), start, end);
    }
}
