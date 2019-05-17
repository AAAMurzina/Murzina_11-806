package com.company;

import java.util.Comparator;

public class Group {
    Student[] students;
    int n = 0;
    Comparator comparator;

    public Group(int size,Comparator comparator) {
        this.students = new Student[size];
        this.comparator = comparator;
    }

    public Group(int size) {
        this.students = new Student[size];
        this.comparator = new ByAgeComparator();
    }

    public void add(Student student){
        int c = 0;
        if (students[c] == null) {
            students[c] = student;
            n++;
        } else {
            if (comparator == null) {
                comparator = new ByAgeComparator();
            }
            while (c < n && comparator.compare(students[c], student) <= 0) {
                c++;
            }
            for (int i = n - 1; i >= c; i--) {
                students[i + 1] = students[i];
            }
            students[c] = student;
            n++;
        }
    }

    public void sort(Comparator comparator) {
        for (int i = students.length-1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (comparator.compare(students[j],students[j+1])>=0) {
                    Student a = students[j];
                    students[j] = students[j+1];
                    students[j + 1] = a;
                }
            }
        }

    }

    public void show() {
        for (int i = 0; i <n; i++) {
            System.out.println(students[i].toString());
        }
    }
}