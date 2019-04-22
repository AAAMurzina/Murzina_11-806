package com.company.superbestawesomeframework;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SuperBestAwesomeFramework {
    static <T> List<T> getMany(Class<T> c, int count) {
        List<T> A = new ArrayList<>();
        try {
            for (int i = 0; i < count; i++) {
                T o = c.newInstance();
                A.add(o);
            }
        } catch (InstantiationException | IllegalAccessException e) {
            throw new IllegalStateException(e);
        }
        return A;
    }

    //создает список экземпляров переданного класс (count штук)
    //в качестве параметров конструктора передает params
    //можно пользоваться getConstructors()
    //можно пользоваться getParameterTypes() у конструктора
    //можно вызывать getClass() у любого параметра из переданных params
    public static <T> List<T> getManyWithCons(Class<T> c, int count, Object... params) throws IllegalAccessException, InvocationTargetException, InstantiationException {
        ArrayList<T> newList = new ArrayList<>();
        for (int i = 0; i <count; i++) {
            Constructor[] Constructors = c.getConstructors();
            Class[] ClassesOfParams = new Class[params.length];
            for (int q = 0; q <params.length; q++) {
                ClassesOfParams[q] = params[q].getClass();
            }
            for (int j = 0; j <Constructors.length ; j++) {
                if (Arrays.equals(Constructors[j].getParameterTypes(), ClassesOfParams)) {
                    newList.add((T) Constructors[j].newInstance(params));
                }

            }

        }
        return newList;
    }

}