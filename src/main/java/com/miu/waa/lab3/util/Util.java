package com.miu.waa.lab3.util;

public class Util {
    public static String getStars(int length) {
        String value = "";

        for (int i = 0; i < length; i++) {
            value += "*";
        }

        return value;
    }
}
