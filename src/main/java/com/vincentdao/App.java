package com.vincentdao;

import com.vincentdao.fluentvalidation.FluentValidation;
import com.vincentdao.result.NoValue;
import com.vincentdao.result.Result;

public final class App {

    private App() {
    }

    public static void main(String[] args) {
        Result<NoValue> result = FluentValidation.start()
                .check(null)
                .withName("lol")
                .toBeNotNull()
                .withMessage("haha")
                .and()
                .toBeInstanceOf(Object.class)
                .and()
                .next()
                .validate();
        System.out.println(result.isSuccessful());
        result.reasons().forEach(reason -> System.out.println(reason.message()));
        System.out.println("---------------------------------");
        result = FluentValidation.start()
                .check("")
                .withName("test string")
                .toBeBlank()
                .and()
                .toBeEmpty()
                .and()
                .toBeNotBlank()
                .and()
                .toBeNotEmpty()
                .and()
                .next()
                .validate();
        System.out.println(result.isSuccessful());
        result.reasons().forEach(reason -> System.out.println(reason.message()));
    }
}
