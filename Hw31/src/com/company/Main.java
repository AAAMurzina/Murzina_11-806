package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char[] chars = str.toCharArray();
//        for (int i = 0; i < str.length(); i++) {
//            for (int k = 1; k < str.length(); k++) {
//                swap(chars, k, k-1);
//                System.out.println(Arrays.toString(chars));
//            }
//        }
        showAllStrings(chars,0,1);
    }


    public static void swap(char[] arr, int i, int j) {
        char c = arr[i];
        arr[i] = arr[j];
        arr[j] = c;
    }

    public static void showAllStrings(char[] arr, int i, int k) {
        if (i == arr.length) {
            return;
        }
        if (k + 1 < arr.length) {
            showAllStrings(arr,i,k + 1);
        }
        else {
            showAllStrings(arr,i + 1,1);
        }
        swap(arr,k,k - 1);
        System.out.println(Arrays.toString(arr));
    }
}