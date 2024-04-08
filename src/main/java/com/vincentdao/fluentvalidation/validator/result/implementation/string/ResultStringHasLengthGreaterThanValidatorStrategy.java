package com.vincentdao.fluentvalidation.validator.result.implementation.string;

import com.vincentdao.fluentvalidation.validator.result.AbstractResultValidator;
import com.vincentdao.fluentvalidation.validator.result.BiPredicateResultValidatorStrategy;
import com.vincentdao.result.NoValue;
import com.vincentdao.result.Result;
import java.util.function.BiPredicate;

public final class ResultStringHasLengthGreaterThanValidatorStrategy<P extends AbstractResultValidator<P, String>>
        extends BiPredicateResultValidatorStrategy<ResultStringHasLengthGreaterThanValidatorStrategy<P>, P, String ,Integer> {

    public ResultStringHasLengthGreaterThanValidatorStrategy(String value, P parentValidator, Result<NoValue> result, Integer other) {
        super(value, parentValidator, result, other);
    }

    @Override
    protected String reason() {
        return "String must have length greater than " + other();
    }

    @Override
    protected BiPredicate<String, Integer> strategy() {
        return ((s, length) -> (s.length() > length));
    }
}
