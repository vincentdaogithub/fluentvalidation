package com.vincentdao.fluentvalidation.common;

public interface TriPredicate<A, B, C> {

    boolean test(A a, B b, C c);
}
