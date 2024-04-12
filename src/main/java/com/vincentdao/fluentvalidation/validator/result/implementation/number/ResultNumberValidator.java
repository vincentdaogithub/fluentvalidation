package com.vincentdao.fluentvalidation.validator.result.implementation.number;

import com.vincentdao.fluentvalidation.FluentValidationProcess;
import com.vincentdao.fluentvalidation.validator.result.AbstractResultNumberValidator;
import com.vincentdao.result.NoValue;
import com.vincentdao.result.Result;

public final class ResultNumberValidator<V extends Number & Comparable<V>>
        extends AbstractResultNumberValidator<ResultNumberValidator<V>, V> {

    public ResultNumberValidator(V value, FluentValidationProcess parent, Result<NoValue> result) {
        super(value, parent, result);
    }
}
