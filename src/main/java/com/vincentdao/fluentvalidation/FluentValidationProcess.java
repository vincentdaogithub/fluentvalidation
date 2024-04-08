package com.vincentdao.fluentvalidation;

import com.vincentdao.fluentvalidation.validator.result.implementation.object.ResultObjectValidator;
import com.vincentdao.fluentvalidation.validator.result.implementation.string.ResultStringValidator;
import com.vincentdao.result.NoValue;
import com.vincentdao.result.Result;

public final class FluentValidationProcess implements FluentProcess {

    private final Result<NoValue> result;

    FluentValidationProcess() {
        this.result = Result.successful().withNoValue();
    }

    public <V> ResultObjectValidator<V> check(V value) {
        return new ResultObjectValidator<>(value, this, result);
    }

    public ResultStringValidator check(String value) {
        return new ResultStringValidator(value, this, result);
    }

    public Result<NoValue> validate() {
        return result;
    }
}
