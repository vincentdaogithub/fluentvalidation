package com.vincentdao.fluentvalidation.validator.result.implementation.object;

import java.util.Objects;
import java.util.function.Predicate;

import com.vincentdao.fluentvalidation.validator.result.AbstractResultValidator;
import com.vincentdao.fluentvalidation.validator.result.PredicateResultValidatorStrategy;
import com.vincentdao.result.NoValue;
import com.vincentdao.result.Result;

public final class ResultNullValidatorStrategy<P extends AbstractResultValidator<P, V>, V>
        extends PredicateResultValidatorStrategy<ResultNullValidatorStrategy<P, V>, P, V> {

    public ResultNullValidatorStrategy(V value, P parentValidator, Result<NoValue> result) {
        super(value, parentValidator, result);
    }

    @Override
    protected String reason() {
        return "must be null";
    }

    @Override
    protected Predicate<V> strategy() {
        return Objects::isNull;
    }
}
