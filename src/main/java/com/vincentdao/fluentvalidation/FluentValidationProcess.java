package com.vincentdao.fluentvalidation;

import com.vincentdao.fluentvalidation.validator.result.AbstractResultNumberValidator;
import com.vincentdao.fluentvalidation.validator.result.AbstractResultObjectValidator;
import com.vincentdao.fluentvalidation.validator.result.AbstractResultStringValidator;
import com.vincentdao.fluentvalidation.validator.result.implementation.number.ResultNumberValidator;
import com.vincentdao.fluentvalidation.validator.result.implementation.object.ResultObjectValidator;
import com.vincentdao.fluentvalidation.validator.result.implementation.string.ResultStringValidator;
import com.vincentdao.result.NoValue;
import com.vincentdao.result.Result;

public final class FluentValidationProcess implements FluentProcess {

    private final Result<NoValue> result;

    FluentValidationProcess() {
        this.result = Result.successful().withNoValue();
    }

    public <V> AbstractResultObjectValidator<ResultObjectValidator<V>, V> check(V value) {
        return new ResultObjectValidator<>(value, this, result);
    }

    public AbstractResultStringValidator<ResultStringValidator> check(String value) {
        return new ResultStringValidator(value, this, result);
    }

    public <V extends Number & Comparable<V>> AbstractResultNumberValidator<ResultNumberValidator<V>, V> check(
            V value) {
        return new ResultNumberValidator<>(value, this, result);
    }

    public Result<NoValue> validate() {
        return result;
    }
}
