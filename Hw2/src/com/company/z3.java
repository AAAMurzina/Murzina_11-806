package com.company;

import java.util.Scanner;

public class z3 {
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int f = n;
        n -= 1;
        while(n != 0)
        {
            f *= n;
            n -= 1;
        }
        System.out.println(f);
    }
}