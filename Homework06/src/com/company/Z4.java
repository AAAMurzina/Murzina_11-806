package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Z4 {


     static boolean p(int[] arr) {
         boolean q = false;
         for (int i = 0; i < arr.length - 1; i++ ){
             if (arr[i] == arr[i + 1]){
                 q = true;
                 break;
             }
         }
     return q;

    }

public static void main(String[] args) {
    int[] arr = {1, 1, 1, 1, 1, 1};
    System.out.println(p(arr));
}
}