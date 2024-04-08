package com.vincentdao.fluentvalidation.validator.result.implementation.object;

import com.vincentdao.fluentvalidation.validator.result.AbstractResultValidator;
import com.vincentdao.fluentvalidation.validator.result.BiPredicateResultValidatorStrategy;
import com.vincentdao.result.NoValue;
import com.vincentdao.result.Result;
import java.util.function.BiPredicate;

public final class ResultNotInstanceOfValidatorStrategy<P extends AbstractResultValidator<P, V>, V>
        extends BiPredicateResultValidatorStrategy<ResultNotInstanceOfValidatorStrategy<P, V>, P, V, Class<?>> {

    public ResultNotInstanceOfValidatorStrategy(V value, P parentValidator, Result<NoValue> result, Class<?> other) {
        super(value, parentValidator, result, other);
        if (other == null) {
            throw new NullPointerException("Class to check against must be defined.");
        }
    }

    @Override
    protected String reason() {
        return String.format("must be not instance of %s", other());
    }

    @Override
    protected BiPredicate<V, Class<?>> strategy() {
        return ((v, clazz) -> !clazz.isInstance(v));
    }
}
