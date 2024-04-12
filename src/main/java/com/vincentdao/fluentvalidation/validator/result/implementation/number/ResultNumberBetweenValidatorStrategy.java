package com.vincentdao.fluentvalidation.validator.result.implementation.number;

import com.vincentdao.fluentvalidation.common.TriPredicate;
import com.vincentdao.fluentvalidation.validator.result.AbstractResultValidator;
import com.vincentdao.fluentvalidation.validator.result.TriPredicateResultValidatorStrategy;
import com.vincentdao.result.NoValue;
import com.vincentdao.result.Result;

public final class ResultNumberBetweenValidatorStrategy<P extends AbstractResultValidator<P, V>, V extends Number & Comparable<V>>
        extends TriPredicateResultValidatorStrategy<ResultNumberBetweenValidatorStrategy<P, V>, P, V, V, V> {

    public ResultNumberBetweenValidatorStrategy(V value, P parentValidator, Result<NoValue> result, V other,
            V another) {
        super(value, parentValidator, result, other, another);
        if (other == null || another == null) {
            throw new NullPointerException("Value to be compared against must be defined.");
        }
        if (other.compareTo(another) > 0) {
            throw new IllegalArgumentException("Start number must be less than or equal to end number.");
        }
    }

    @Override
    protected TriPredicate<V, V, V> strategy() {
        return ((v, o, a) -> (v.compareTo(o) >= 0) && (v.compareTo(a) <= 0));
    }

    @Override
    protected String reason() {
        return String.format("must be between %s and %s", other(), another());
    }
}
