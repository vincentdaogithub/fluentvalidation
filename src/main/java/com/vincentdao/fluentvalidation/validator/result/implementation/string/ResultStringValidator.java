package com.vincentdao.fluentvalidation.validator.result.implementation.string;

import com.vincentdao.fluentvalidation.FluentValidationProcess;
import com.vincentdao.fluentvalidation.validator.result.AbstractResultStringValidator;
import com.vincentdao.result.NoValue;
import com.vincentdao.result.Result;

public final class ResultStringValidator extends AbstractResultStringValidator<ResultStringValidator> {

    public ResultStringValidator(String value, FluentValidationProcess parent, Result<NoValue> result) {
        super(value, parent, result);
    }
}
