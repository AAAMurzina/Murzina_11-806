package com.company;

import java.util.Scanner;

public class Z4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = 0;
        int m = 0;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int p = arr[n - 1];
        int pp = arr[n - 2];
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] <= arr[i + 1]) {
                k++;
            }
        }
        for (int i = k; i < n - 1; i++){
            if (arr[i] >= arr[i + 1]){
                m++;
            }
            }


            if ((k + m + 1) == n && p <= pp ) {
                System.out.println("Yes");
            } else System.out.println("No");

    }
}
