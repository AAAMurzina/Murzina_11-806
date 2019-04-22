package com.company.superbestawesomeframework;

import com.company.Student;

import java.util.List;

import static com.company.superbestawesomeframework.SuperBestAwesomeFramework.*;

public class Main {
    public static void main(String[] args) {
        List<SimplStudent> A =
                getMany(SimplStudent.class, 100);
        System.out.println(A);

        List<StringBuilder> K =
                getMany(StringBuilder.class, 10);
        System.out.println(K);
    }
}