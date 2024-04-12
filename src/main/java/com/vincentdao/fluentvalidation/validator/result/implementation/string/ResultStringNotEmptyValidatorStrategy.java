package com.vincentdao.fluentvalidation.validator.result.implementation.string;

import java.util.function.Predicate;

import com.vincentdao.fluentvalidation.validator.result.AbstractResultValidator;
import com.vincentdao.fluentvalidation.validator.result.PredicateResultValidatorStrategy;
import com.vincentdao.result.NoValue;
import com.vincentdao.result.Result;

public final class ResultStringNotEmptyValidatorStrategy<P extends AbstractResultValidator<P, String>>
        extends PredicateResultValidatorStrategy<ResultStringNotEmptyValidatorStrategy<P>, P, String> {

    public ResultStringNotEmptyValidatorStrategy(String value, P parentValidator, Result<NoValue> result) {
        super(value, parentValidator, result);
    }

    @Override
    protected String reason() {
        return "String must not be empty";
    }

    @Override
    protected Predicate<String> strategy() {
        return (s -> ((s != null) && !s.isEmpty()));
    }
}
