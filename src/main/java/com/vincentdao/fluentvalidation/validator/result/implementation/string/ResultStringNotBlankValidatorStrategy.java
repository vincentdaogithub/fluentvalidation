package com.vincentdao.fluentvalidation.validator.result.implementation.string;

import com.vincentdao.fluentvalidation.validator.result.AbstractResultValidator;
import com.vincentdao.fluentvalidation.validator.result.PredicateResultValidatorStrategy;
import com.vincentdao.result.NoValue;
import com.vincentdao.result.Result;
import java.util.function.Predicate;

public final class ResultStringNotBlankValidatorStrategy<P extends AbstractResultValidator<P, String>>
        extends PredicateResultValidatorStrategy<ResultStringNotBlankValidatorStrategy<P>, P, String> {

    public ResultStringNotBlankValidatorStrategy(String value, P parentValidator, Result<NoValue> result) {
        super(value, parentValidator, result);
    }

    @Override
    protected String reason() {
        return "String must not be blank";
    }

    @Override
    protected Predicate<String> strategy() {
        return (s -> ((s != null) && !s.trim().isEmpty()));
    }
}
