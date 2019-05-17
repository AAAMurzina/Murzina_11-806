package com.company;

public class Student {
    private int age;
    private String name;
    private String faculty;

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", faculty='" + faculty + '\'' +
                '}';
    }

    public Student(int age, String name, String faculty) {
        this.age = age;
        this.name = name;
        this.faculty = faculty;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getFaculty() {
        return faculty;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Student)) {
            return false;
        }
        Student student = (Student) obj;
        return this.age == student.age &&
                this.name.equals(student.name) &&
                this.faculty.equals(student.faculty);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = result * 31 + age;
        result = result * 31 + name.hashCode();
        result = result * 31 + faculty.hashCode();
        return result;
    }
}