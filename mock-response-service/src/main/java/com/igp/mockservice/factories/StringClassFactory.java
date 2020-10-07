package com.igp.mockservice.factories;

import java.util.List;

public class StringClassFactory {

    public static Class<?> cast(String input) {
        if (input.equalsIgnoreCase("String")) {
            return String.class;
        } else if (input.equalsIgnoreCase("Integer") || input.equalsIgnoreCase("int")) {
            return Integer.class;
        } else if (input.equalsIgnoreCase("Float")) {
            return Float.class;
        } else if (input.equalsIgnoreCase("Boolean") || input.equalsIgnoreCase("Bool")) {
            return Boolean.class;
        } else if (input.equalsIgnoreCase("Double")) {
            return Double.class;
        } else if (input.equalsIgnoreCase("Short")) {
            return Short.class;
        } else if (input.equalsIgnoreCase("List")) {
            return List.class;
        } else {
            throw new IllegalArgumentException();
        }
    }
}
