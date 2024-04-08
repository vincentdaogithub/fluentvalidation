package com.vincentdao.fluentvalidation.validator.result.implementation.object;

import com.vincentdao.fluentvalidation.validator.result.AbstractResultValidator;
import com.vincentdao.fluentvalidation.validator.result.PredicateResultValidatorStrategy;
import com.vincentdao.result.NoValue;
import com.vincentdao.result.Result;
import java.util.Objects;
import java.util.function.Predicate;

public final class ResultNotNullValidatorStrategy<P extends AbstractResultValidator<P, V>, V>
        extends PredicateResultValidatorStrategy<ResultNotNullValidatorStrategy<P, V>, P, V> {

    public ResultNotNullValidatorStrategy(V value, P parentValidator, Result<NoValue> result) {
        super(value, parentValidator, result);
    }

    @Override
    protected String reason() {
        return "must not be null";
    }

    @Override
    protected Predicate<V> strategy() {
        return Objects::nonNull;
    }
}
