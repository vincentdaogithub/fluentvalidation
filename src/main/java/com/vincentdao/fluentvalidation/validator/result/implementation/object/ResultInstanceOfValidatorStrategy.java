package com.vincentdao.fluentvalidation.validator.result.implementation.object;

import java.util.function.BiPredicate;

import com.vincentdao.fluentvalidation.validator.result.AbstractResultValidator;
import com.vincentdao.fluentvalidation.validator.result.BiPredicateResultValidatorStrategy;
import com.vincentdao.result.NoValue;
import com.vincentdao.result.Result;

public final class ResultInstanceOfValidatorStrategy<P extends AbstractResultValidator<P, V>, V>
        extends BiPredicateResultValidatorStrategy<ResultInstanceOfValidatorStrategy<P, V>, P, V, Class<?>> {

    public ResultInstanceOfValidatorStrategy(V value, P parentValidator, Result<NoValue> result, Class<?> other) {
        super(value, parentValidator, result, other);
        if (other == null) {
            throw new NullPointerException("Class to check against must be defined.");
        }
    }

    @Override
    protected String reason() {
        return String.format("must be instance of %s", other());
    }

    @Override
    protected BiPredicate<V, Class<?>> strategy() {
        return ((v, clazz) -> clazz.isInstance(v));
    }
}
