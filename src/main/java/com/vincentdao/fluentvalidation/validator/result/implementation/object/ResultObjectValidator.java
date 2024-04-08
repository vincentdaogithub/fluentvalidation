package com.vincentdao.fluentvalidation.validator.result.implementation.object;

import com.vincentdao.fluentvalidation.FluentValidationProcess;
import com.vincentdao.fluentvalidation.validator.result.AbstractResultObjectValidator;
import com.vincentdao.result.NoValue;
import com.vincentdao.result.Result;

public final class ResultObjectValidator<V>
        extends AbstractResultObjectValidator<ResultObjectValidator<V>, V> {

    public ResultObjectValidator(V value, FluentValidationProcess process, Result<NoValue> result) {
        super(value, process, result);
    }
}
