package com.vincentdao.fluentvalidation.validator.result.implementation.number;

import java.util.function.BiPredicate;

import com.vincentdao.fluentvalidation.validator.result.AbstractResultValidator;
import com.vincentdao.fluentvalidation.validator.result.BiPredicateResultValidatorStrategy;
import com.vincentdao.result.NoValue;
import com.vincentdao.result.Result;

public final class ResultNumberGreaterThanOrEqualValidatorStrategy<P extends AbstractResultValidator<P, V>, V extends Number & Comparable<V>>
        extends BiPredicateResultValidatorStrategy<ResultNumberGreaterThanOrEqualValidatorStrategy<P, V>, P, V, V> {

    public ResultNumberGreaterThanOrEqualValidatorStrategy(V value, P parentValidator, Result<NoValue> result,
            V other) {
        super(value, parentValidator, result, other);
        if (other == null) {
            throw new NullPointerException("Value to be compared against must be defined.");
        }
    }

    @Override
    protected BiPredicate<V, V> strategy() {
        return ((v, o) -> (v.compareTo(o) >= 0));
    }

    @Override
    protected String reason() {
        return String.format("must be greater than or equal %s", other());
    }
}
