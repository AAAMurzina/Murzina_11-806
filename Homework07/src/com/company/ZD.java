package com.company;

import java.sql.SQLOutput;
import java.util.Scanner;
    public class ZD {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Введите число: ");
            int n = sc.nextInt();
            if (res(n) == 1) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }

        static int res(int n) {
            if ((n > 1) && (n % 2 == 0)) {
                return res(n / 2);
            } else if (n == 1) {
                return 1;
            } else {
                return 0;
            }
        }
    }