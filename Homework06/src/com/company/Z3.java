package com.company;

import java.util.Arrays;
import java.util.Scanner;


public class Z3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        char[] m =s.toCharArray();
        int k = 0;
        int o = 0;
        for (int i = 0; i < m.length - 1; i++) {
            if (m[i] == m[i + 1]) {
                k++;
                if (k > o){
                    o = k;
                }
            }
        }
        System.out.println(o);
        }
    }