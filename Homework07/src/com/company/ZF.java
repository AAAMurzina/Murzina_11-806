package com.company;

import java.util.Scanner;

public class ZF {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите число: ");
        int n = sc.nextInt();
        System.out.print(res(n));

    }

    public static int res(int n) {
        if (n <= 9) {
            return n;
        } else {
            System.out.print(n % 10 + " ");
            return res(n / 10);
        }
    }
}