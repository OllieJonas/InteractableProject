package com.igp.zuulservice.util;

/**
 * Based on {@link java.util.function.Function}, however provides the ability to provide three arguments, then responds
 * with a given return type.
 *
 * @param <T> The type of the first object
 * @param <S> The type of the second object
 * @param <U> The type of the third object
 *
 * @param <V> The return type
 */
public interface TriFunction<T, S, U, V> {
    V apply(T t, S s, U u);
}
