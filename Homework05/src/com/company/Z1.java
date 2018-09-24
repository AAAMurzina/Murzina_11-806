package com.company;

import java.util.Scanner;

public class Z1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double Result = 0;
        double fn = 0;
        double sn = 0;
        int n = 1;
        String reset = "y";
        while (n == 1) {
            if (reset.equals("y")){
                System.out.println("First number: ");
                fn = sc.nextDouble();
            }
            else {
                fn = Result;
            }
            System.out.println("Select the operation(+,-,*,/)");
            String operat = sc.next();
            System.out.println("Second number: ");
            sn = sc.nextDouble();
             if (operat.equals("-")){
                 Result = fn - sn;
                 System.out.println(Result);
             }
             if (operat.equals("+")){
                 Result = fn + sn;
                 System.out.println(Result);
             }
             if (operat.equals("*")){
                 Result = fn * sn;
                 System.out.println(Result);
             }
             if (operat.equals("/")){
                 Result = fn / sn;
                 System.out.println(Result);
             }
             System.out.println("Reset? (y/n)");
             reset = sc.next();
        }
    }
}
