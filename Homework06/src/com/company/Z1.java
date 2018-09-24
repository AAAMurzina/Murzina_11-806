package com.company;

import java.util.Arrays;


public class Z1 {

    public static void main(String[] args) {
        String[] m = {"bauhbiuahbiahiib", "naeothdb", "zlp", "aa"};
        System.out.println(Arrays.toString(m));
        boolean kl;
        do {
            kl = false;
            for (int i = 1; i < m.length; i++) {
                if (m[i - 1].length() > m[i].length()){
                    String u = m[i - 1];
                    m[i - 1] = m[i];
                    m[i] = u;
                    kl = true;
                }
            }
        } while (kl);
        System.out.println(Arrays.toString(m));
    }
}