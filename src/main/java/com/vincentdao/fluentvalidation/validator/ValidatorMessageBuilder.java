package com.vincentdao.fluentvalidation.validator;

final class ValidatorMessageBuilder {

    private static final String DEFAULT_MESSAGE_FORMAT = "'%s' %s.";

    private ValidatorMessageBuilder() {
    }

    static String buildDefault(String name, String reason) {
        return String.format(DEFAULT_MESSAGE_FORMAT, name, reason);
    }
}
