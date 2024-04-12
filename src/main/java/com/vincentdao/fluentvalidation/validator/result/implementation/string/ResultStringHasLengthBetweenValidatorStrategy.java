package com.vincentdao.fluentvalidation.validator.result.implementation.string;

import com.vincentdao.fluentvalidation.common.TriPredicate;
import com.vincentdao.fluentvalidation.validator.result.AbstractResultValidator;
import com.vincentdao.fluentvalidation.validator.result.TriPredicateResultValidatorStrategy;
import com.vincentdao.result.NoValue;
import com.vincentdao.result.Result;

public final class ResultStringHasLengthBetweenValidatorStrategy<P extends AbstractResultValidator<P, String>>
        extends TriPredicateResultValidatorStrategy<ResultStringHasLengthBetweenValidatorStrategy<P>, P, String, Integer, Integer> {

    public ResultStringHasLengthBetweenValidatorStrategy(String value, P parentValidator, Result<NoValue> result,
            Integer other, Integer another) {
        super(value, parentValidator, result, other, another);
    }

    @Override
    protected String reason() {
        return String.format("String must have length between %d and %d", other(), another());
    }

    @Override
    protected TriPredicate<String, Integer, Integer> strategy() {
        return ((s, start, end) -> ((start <= s.length()) && (s.length() <= end)));
    }
}
