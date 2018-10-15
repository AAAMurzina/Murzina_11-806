package com.company;

import java.util.Scanner;

public class ZG {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите число: ");
        int n = sc.nextInt();
        System.out.print(res(n) + " ");
    }
    public static int res(int n){
        if (n <= 9){
            return n;
        } else {
            int zlp = res(n / 10);
            int p = res(n % 10);
            System.out.print(zlp + " ");
            return p;
        }
    }
}

