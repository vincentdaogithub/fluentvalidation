package com.vincentdao.fluentvalidation.validator.result;

import com.vincentdao.result.NoValue;
import com.vincentdao.result.Result;
import java.util.function.Predicate;

public abstract class PredicateResultValidatorStrategy<
        S extends PredicateResultValidatorStrategy<S, P, V>,
        P extends AbstractResultValidator<P, V>,
        V> extends AbstractResultValidatorStrategy<S, P, V> {

    protected PredicateResultValidatorStrategy(V value, P parentValidator, Result<NoValue> result) {
        super(value, parentValidator, result);
    }

    protected abstract Predicate<V> strategy();

    @Override
    protected final void validate() {
        if (!strategy().test(value())) {
            result().withFailureMessage(message());
        }
    }
}
