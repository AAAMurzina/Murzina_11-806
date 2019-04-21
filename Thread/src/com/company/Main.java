package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static int mainSum = 0;
    public static void main(String[] args) throws InterruptedException {
        Random r = new Random();
        int n = 1000000;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = (r.nextInt(10));
            mainSum += arr[i];
        }
            System.out.println(mainSum);
        mainSum = 0;

        List<Thread> threadList = new ArrayList<>();
        int numInOne = 200000;
        for (int i = 0; i < 5; i++) {
            CounterThread first = new CounterThread(arr, i * numInOne, (i + 1) * numInOne);
            first.start();
            threadList.add(first);

        }

        for (Thread t : threadList) {
            t.join();
        }

        System.out.println(mainSum);


    }
}