package com.company;

public class Student {
    private int age;
    private String firstName;
    private String secondName;

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
                this.firstName.equals(student.firstName) &&
                this.secondName.equals(student.secondName);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = result * 31 + age;
        result = result * 31 + firstName.hashCode();
        result = result * 31 + secondName.hashCode();
        return result;
    }
}