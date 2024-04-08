package com.vincentdao.fluentvalidation.validator.result;

import com.vincentdao.fluentvalidation.FluentValidationProcess;
import com.vincentdao.fluentvalidation.validator.result.implementation.string.ResultStringBlankValidatorStrategy;
import com.vincentdao.fluentvalidation.validator.result.implementation.string.ResultStringEmptyValidatorStrategy;
import com.vincentdao.fluentvalidation.validator.result.implementation.string.ResultStringHasLengthBetweenValidatorStrategy;
import com.vincentdao.fluentvalidation.validator.result.implementation.string.ResultStringHasLengthGreaterThanOrEqualValidatorStrategy;
import com.vincentdao.fluentvalidation.validator.result.implementation.string.ResultStringHasLengthGreaterThanValidatorStrategy;
import com.vincentdao.fluentvalidation.validator.result.implementation.string.ResultStringHasLengthLessThanOrEqualValidatorStrategy;
import com.vincentdao.fluentvalidation.validator.result.implementation.string.ResultStringHasLengthLessThanValidatorStrategy;
import com.vincentdao.fluentvalidation.validator.result.implementation.string.ResultStringHasLengthValidatorStrategy;
import com.vincentdao.fluentvalidation.validator.result.implementation.string.ResultStringNotBlankValidatorStrategy;
import com.vincentdao.fluentvalidation.validator.result.implementation.string.ResultStringNotEmptyValidatorStrategy;
import com.vincentdao.result.NoValue;
import com.vincentdao.result.Result;

public abstract class AbstractResultStringValidator<S extends AbstractResultStringValidator<S>>
        extends AbstractResultObjectValidator<S, String> {

    protected AbstractResultStringValidator(String value, FluentValidationProcess parent, Result<NoValue> result) {
        super(value, parent, result);
    }

    public AbstractResultValidatorStrategy<ResultStringNotEmptyValidatorStrategy<S>, S, String> toBeNotEmpty() {
        return new ResultStringNotEmptyValidatorStrategy<>(value(), self(), result());
    }

    public AbstractResultValidatorStrategy<ResultStringEmptyValidatorStrategy<S>, S, String> toBeEmpty() {
        return new ResultStringEmptyValidatorStrategy<>(value(), self(), result());
    }

    public AbstractResultValidatorStrategy<ResultStringNotBlankValidatorStrategy<S>, S, String> toBeNotBlank() {
        return new ResultStringNotBlankValidatorStrategy<>(value(), self(), result());
    }

    public AbstractResultValidatorStrategy<ResultStringBlankValidatorStrategy<S>, S, String> toBeBlank() {
        return new ResultStringBlankValidatorStrategy<>(value(), self(), result());
    }

    public AbstractResultValidatorStrategy<ResultStringHasLengthValidatorStrategy<S>, S, String> hasLength(int length) {
        return new ResultStringHasLengthValidatorStrategy<>(value(), self(), result(), length);
    }

    public AbstractResultValidatorStrategy<ResultStringHasLengthLessThanValidatorStrategy<S>, S, String> hasLengthLessThan(int length) {
        return new ResultStringHasLengthLessThanValidatorStrategy<>(value(), self(), result(), length);
    }

    public AbstractResultValidatorStrategy<ResultStringHasLengthGreaterThanValidatorStrategy<S>, S, String> hasLengthGreaterThan(int length) {
        return new ResultStringHasLengthGreaterThanValidatorStrategy<>(value(), self(), result(), length);
    }

    public AbstractResultValidatorStrategy<ResultStringHasLengthLessThanOrEqualValidatorStrategy<S>, S, String> hasLengthLessThanOrEqualTo(int length) {
        return new ResultStringHasLengthLessThanOrEqualValidatorStrategy<>(value(), self(), result(), length);
    }

    public AbstractResultValidatorStrategy<ResultStringHasLengthGreaterThanOrEqualValidatorStrategy<S>, S, String> hasLengthGreaterThanOrEqualTo(int length) {
        return new ResultStringHasLengthGreaterThanOrEqualValidatorStrategy<>(value(), self(), result(), length);
    }

    public AbstractResultValidatorStrategy<ResultStringHasLengthBetweenValidatorStrategy<S>, S, String> hasLengthBetween(int start, int end) {
        return new ResultStringHasLengthBetweenValidatorStrategy<>(value(), self(), result(), start, end);
    }
}
