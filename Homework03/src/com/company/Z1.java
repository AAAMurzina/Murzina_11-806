package com.company;

import java.util.Scanner;

public class Z1{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int [n];
        float sr = 0;
        int k = 0;
        for (int i = 0; i < n; i++){
            arr[i] = sc.nextInt();}
            for (int i = 0; i < n; i++){
                sr = sr + arr[i];

            }
            sr = sr / n;
            for (int i = 0; i < n; i++){
                if (arr[i] > sr){
                    k++;
                }
            }

        System.out.println(sr);
        System.out.println(k);

    }
}
