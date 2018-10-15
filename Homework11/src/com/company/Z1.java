package com.company;

import com.sun.xml.internal.fastinfoset.util.CharArray;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Z1 {

    public static void main(String[] args) throws FileNotFoundException {
	File file = new File("C:\\Users\\Alena\\Desktop\\11.txt");
        Scanner sc = new Scanner(file);
        String[] arr = new String[zlp(file)];

        for (int i = 0; i < arr.length; i++){
            arr[i] = sc.nextLine();
        }
        System.out.println(Arrays.toString(sort(arr)));
    }

    public static int zlp(File file) throws FileNotFoundException {
        Scanner sc = new Scanner(file);
        int k = 0;
        while (sc.hasNextLine()){
            k++;
            sc.nextLine();
        }
        return k;
    }
    static String[] sort(String[] a) {
        char[][] arr = new char[a.length][];
        for (int i = 0; i < a.length; i++) {
            arr[i] = a[i].toCharArray();

        }
        int n = arr.length;
        boolean wasChangedOnLastIteration = true;
        for (int i = 0; i < n & wasChangedOnLastIteration; i++) {
            wasChangedOnLastIteration = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j][0] < arr[j + 1][0]) {
                    char[] buf = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = buf;
                    wasChangedOnLastIteration = true;
                }
            }
        }
        for (int i = 0; i < a.length; i++){
            a[i] = String.valueOf(a[i]);
        }
        return a;
    }

}


