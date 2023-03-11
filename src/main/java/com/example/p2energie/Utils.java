package com.example.p2energie;

public final class Utils {
    public static Boolean isFloat(String value) {

        try {
            Float.parseFloat(value);

        } catch(NumberFormatException e) {
            return false;

        }

        return true;
    }
}
