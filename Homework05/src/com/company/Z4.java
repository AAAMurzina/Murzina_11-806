package com.company;

import java.util.Scanner;
public class Z4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("String: ");
        String s = sc.next();
        System.out.println("Введите ключ: (u/l)");
        String p = sc.next();
        if (p.equals("u")){
            s = s.toUpperCase();

        }
        else if (p.equals("l")){
            s = s.toLowerCase();
        }
        System.out.println(s);
    }
}
