package com.vincentdao.fluentvalidation.validator.result.implementation.object;

import java.util.Objects;
import java.util.function.BiPredicate;

import com.vincentdao.fluentvalidation.validator.result.AbstractResultValidator;
import com.vincentdao.fluentvalidation.validator.result.BiPredicateResultValidatorStrategy;
import com.vincentdao.result.NoValue;
import com.vincentdao.result.Result;

public final class ResultEqualValidatorStrategy<P extends AbstractResultValidator<P, V>, V, O>
        extends BiPredicateResultValidatorStrategy<ResultEqualValidatorStrategy<P, V, O>, P, V, O> {

    public ResultEqualValidatorStrategy(V value, P parentValidator, Result<NoValue> result, O other) {
        super(value, parentValidator, result, other);
    }

    @Override
    protected String reason() {
        return String.format("must be equal to %s", other());
    }

    @Override
    protected BiPredicate<V, O> strategy() {
        return Objects::deepEquals;
    }
}
