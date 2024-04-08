package com.vincentdao.fluentvalidation.validator.result.implementation.string;

import com.vincentdao.fluentvalidation.validator.result.AbstractResultValidator;
import com.vincentdao.fluentvalidation.validator.result.PredicateResultValidatorStrategy;
import com.vincentdao.result.NoValue;
import com.vincentdao.result.Result;
import java.util.function.Predicate;

public final class ResultStringEmptyValidatorStrategy<P extends AbstractResultValidator<P, String>>
        extends PredicateResultValidatorStrategy<ResultStringEmptyValidatorStrategy<P>, P, String> {

    public ResultStringEmptyValidatorStrategy(String value, P parentValidator, Result<NoValue> result) {
        super(value, parentValidator, result);
    }

    @Override
    protected String reason() {
        return "String must be empty";
    }

    @Override
    protected Predicate<String> strategy() {
        return (s -> ((s == null) || s.isEmpty()));
    }
}
