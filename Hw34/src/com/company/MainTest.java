package com.company;

import com.company.superbestawesomeframework.SuperBestAwesomeFramework;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class MainTest {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        List testList = SuperBestAwesomeFramework.getManyWithCons(Student.class, 1, "John", 18);
        System.out.println(testList.toString());
        System.out.println(testList.size());
    }
}