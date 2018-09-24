package com.company;

import java.util.Arrays;

public class Z2 {

    private static String ltrim(String a) {
        char[] p = a.toCharArray();
        for (int i = 0; i < p.length; i++) {
            if (p[i] != ' ') {
                return String.valueOf(Arrays.copyOfRange(p, i, p.length));
            }
        }
        return "";
    }

    public static void main(String[] args) {
        String a = "   aabd";
        System.out.println(ltrim(a));
    }
}