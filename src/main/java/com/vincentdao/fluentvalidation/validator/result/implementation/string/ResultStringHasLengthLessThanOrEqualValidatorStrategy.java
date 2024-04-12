package com.vincentdao.fluentvalidation.validator.result.implementation.string;

import java.util.function.BiPredicate;

import com.vincentdao.fluentvalidation.validator.result.AbstractResultValidator;
import com.vincentdao.fluentvalidation.validator.result.BiPredicateResultValidatorStrategy;
import com.vincentdao.result.NoValue;
import com.vincentdao.result.Result;

public final class ResultStringHasLengthLessThanOrEqualValidatorStrategy<P extends AbstractResultValidator<P, String>>
        extends BiPredicateResultValidatorStrategy<ResultStringHasLengthLessThanOrEqualValidatorStrategy<P>, P, String, Integer> {

    public ResultStringHasLengthLessThanOrEqualValidatorStrategy(String value, P parentValidator,
            Result<NoValue> result, Integer other) {
        super(value, parentValidator, result, other);
    }

    @Override
    protected String reason() {
        return "String must have length less than or equal to " + other();
    }

    @Override
    protected BiPredicate<String, Integer> strategy() {
        return ((s, length) -> (s.length() <= length));
    }
}
