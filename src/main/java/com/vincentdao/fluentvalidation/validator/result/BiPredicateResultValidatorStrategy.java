package com.vincentdao.fluentvalidation.validator.result;

import java.util.function.BiPredicate;

import com.vincentdao.result.NoValue;
import com.vincentdao.result.Result;

public abstract class BiPredicateResultValidatorStrategy<S extends BiPredicateResultValidatorStrategy<S, P, V, O>, P extends AbstractResultValidator<P, V>, V, O>
        extends AbstractResultValidatorStrategy<S, P, V> {

    private final O other;

    protected BiPredicateResultValidatorStrategy(V value, P parentValidator, Result<NoValue> result, O other) {
        super(value, parentValidator, result);
        this.other = other;
    }

    protected abstract BiPredicate<V, O> strategy();

    @Override
    protected final void validate() {
        if (!strategy().test(value(), other())) {
            result().withFailureMessage(message());
        }
    }

    protected final O other() {
        return other;
    }
}
