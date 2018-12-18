package com.company;

import java.util.Scanner;

public class z4 {
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int num;
        int chet = 0;
        int nechet = 0;
        for(int i = 0; i < n; i++)
        {
            num = in.nextInt();
            if(num % 2 == 0)
                chet += num;
            else
                nechet += num;
        }
        System.out.println(chet - nechet);
    }
}