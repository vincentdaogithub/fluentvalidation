package com.vincentdao.fluentvalidation.validator.result;

import com.vincentdao.fluentvalidation.common.TriPredicate;
import com.vincentdao.result.NoValue;
import com.vincentdao.result.Result;

public abstract class TriPredicateResultValidatorStrategy<
        S extends TriPredicateResultValidatorStrategy<S, P, V, O, A>,
        P extends AbstractResultValidator<P, V>,
        V, O, A> extends AbstractResultValidatorStrategy<S, P, V> {

    private final O other;
    private final A another;

    protected TriPredicateResultValidatorStrategy(V value, P parentValidator, Result<NoValue> result, O other, A another) {
        super(value, parentValidator, result);
        this.other = other;
        this.another = another;
    }

    protected abstract TriPredicate<V, O, A> strategy();

    @Override
    protected final void validate() {
        if (!strategy().test(value(), other(), another())) {
            result().withFailureMessage(message());
        }
    }

    protected final O other() {
        return other;
    }

    protected final A another() {
        return another;
    }
}
