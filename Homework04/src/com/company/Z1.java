package com.company;

import java.util.Scanner;

public class Z1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int n = s.length();
        String s2 = sc.next();
        int m = s2.length();
        int c = 0;
        int q = 0;
        char[] p = s.toCharArray();
        char[] v = s2.toCharArray();
        for (int i = 0; i <n; i++) {
            c = 0;
            for (int j = 0; j <m; j++) {
                if (p[i] == v[j]) {
                    c++;
                    q = i;
                }
                else if (c == m)
                    break;
            }
        }
        System.out.println(q - m + 1);
    }
}