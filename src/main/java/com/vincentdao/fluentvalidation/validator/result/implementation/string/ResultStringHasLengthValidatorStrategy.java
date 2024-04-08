package com.vincentdao.fluentvalidation.validator.result.implementation.string;

import com.vincentdao.fluentvalidation.validator.result.AbstractResultValidator;
import com.vincentdao.fluentvalidation.validator.result.BiPredicateResultValidatorStrategy;
import com.vincentdao.result.NoValue;
import com.vincentdao.result.Result;
import java.util.function.BiPredicate;

public final class ResultStringHasLengthValidatorStrategy<P extends AbstractResultValidator<P, String>>
        extends BiPredicateResultValidatorStrategy<ResultStringHasLengthValidatorStrategy<P>, P, String, Integer> {

    public ResultStringHasLengthValidatorStrategy(
            String value,
            P parentValidator,
            Result<NoValue> result,
            Integer other) {
        super(value, parentValidator, result, other);
        if (other == null) {
            throw new NullPointerException("Length to check against must be defined.");
        }
    }

    @Override
    protected String reason() {
        return "String must have length " + other();
    }

    @Override
    protected BiPredicate<String, Integer> strategy() {
        return ((s, length) -> (s.length() == length));
    }
}