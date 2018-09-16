package com.company;

import java.util.Scanner;

public class Z2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = 0;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] > max && arr[i] > 0) {
                max = arr[i];
                k = i;
            }
            if (arr[i] < 0 && -arr[i] > max) {
                max = -arr[i];
                k = i;
            }

        }
        System.out.println(k);
    }
}