package com.vincentdao.fluentvalidation;

public final class FluentValidation {

    private FluentValidation() {
    }

    public static FluentValidationProcess start() {
        return new FluentValidationProcess();
    }
}
