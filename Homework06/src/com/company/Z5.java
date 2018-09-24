package com.company;

import java.util.Arrays;
import java.util.Scanner;


public class Z5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = 0;
        System.out.println("Введите кол-во значений в массивах: ");
        int n = sc.nextInt();
        System.out.println("Введите значения в 1 массиве: ");
        int[] arr = new int [n];
        for (int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println("Введите значения во 2 масссиве: ");
        int[] arr2 = new int [n];
        for (int j = 0; j < n; j++){
            arr2[j] = sc.nextInt();
        }
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if (arr[i] != arr2[j] && j == n )
                    k++;
            }
        }
        System.out.println(k);
    }
    }