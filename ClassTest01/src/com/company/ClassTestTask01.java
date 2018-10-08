// 1 ВАРИАНТ;
package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class ClassTestTask01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n * n];
        int[][] matrix = new int [n][n];
        for (int i = 0; i < n * n; i++) {
            arr[i] = sc.nextInt();
        }
        sortArr(arr);
        for (int i = 0; i < n * n; i++) {
            System.out.print(arr[i] + " ");
        }
        fillSpiral(matrix,arr);
        System.out.println(overDiagonalSum(matrix, n));
    }

    public static void sortArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                arr[i] *= -1;
            }
        }
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int m = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = m;
                }

            }
        }
    }

    static void fillSpiral(int[][] matrix, int[] arr) {
        int n = matrix.length;
        int k = 0;
        for (int i = 0; i < n / 2; i++) {
            for (int j = i; j < n - 1 - i; j++) {
                matrix[i][j] = arr[k];
                k += 1;
            }
            for (int j = i; j < n - 1 - i; j++) {
                matrix[j][n - 1 - i] = arr[k];
                k += 1;
            }
            for (int j = n - 1 - i; j > i; j--) {
                matrix[n - 1 - i][j] = arr[k];
                k += 1;
            }
            for (int j = n - 1 - i; j > i; j--) {
                matrix[j][i] = arr[k];
                k += 1;
            }
        }
        if (n % 2 == 1) {
            matrix[n / 2][n / 2] = arr[k + 1];
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }
    static int overDiagonalSum(int[][] matrix, int n){
        int sum = 0;
        for ( int i = 1; i < n; i++){
            sum += matrix[i][i];
        }
        return sum;
    }
}



