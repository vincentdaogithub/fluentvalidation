package com.vincentdao.fluentvalidation.validator.result.implementation.object;

import com.vincentdao.fluentvalidation.validator.result.AbstractResultValidator;
import com.vincentdao.fluentvalidation.validator.result.BiPredicateResultValidatorStrategy;
import com.vincentdao.result.NoValue;
import com.vincentdao.result.Result;
import java.util.Objects;
import java.util.function.BiPredicate;

public final class ResultNotEqualValidatorStrategy<P extends AbstractResultValidator<P, V>, V, O>
        extends BiPredicateResultValidatorStrategy<ResultNotEqualValidatorStrategy<P, V, O>, P, V, O> {

    public ResultNotEqualValidatorStrategy(V value, P parentValidator, Result<NoValue> result, O other) {
        super(value, parentValidator, result, other);
    }

    @Override
    protected String reason() {
        return String.format("must be equal to %s", other());
    }

    @Override
    protected BiPredicate<V, O> strategy() {
        return ((v, o) -> !Objects.deepEquals(v, o));
    }
}
