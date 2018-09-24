package com.company;

import java.util.Scanner;
public class Z2 {

    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("STRING: ");
    String s = sc.nextLine();
    String p = "";
    for (int i = 0; i < s.length(); i++){
        char t = s.charAt(i);
        if (t == '0' || t == '1' || t == '2' || t == '3' || t == '4' || t == '5' || t == '6' || t == '7' || t == '8' || t == '9') {
            t = '*';
        }
        else if (t == ' ') {
            t = ' ';
        }
        p += t;
    }
    System.out.println("OUTPUT: " + p);
    }
    }