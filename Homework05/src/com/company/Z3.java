package com.company;

import java.util.Scanner;

public class Z3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("STRING: ");
        String s = sc.next();
        char[] m = s.toCharArray();
        long zlp = 0;
        long p = 1;
        for (int i = s.length() - 1; i >= 0; i--) {
            zlp += p * (m[i] - '0');
            p *= 10;
        }
        System.out.println(zlp);
    }
}