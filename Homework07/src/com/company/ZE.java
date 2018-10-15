package com.company;

import java.util.Scanner;

public class ZE {
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("ведите число: ");
        int n = sc.nextInt();
        System.out.println("Сумма: " + res(n));
    }

    public static int res(int n) {
        if (n <= 9) {
            return n;
        } else {
            return n % 10 + res(n / 10);
        }
    }
}
