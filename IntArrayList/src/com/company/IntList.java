package com.company;

public interface IntList {
    void add(int e);
    //добавление элемента в конец списка

    int get(int index);
    //получение элемента по индексу

    int size();
    //число элементов в списке

    boolean contains(int value);
    //содержится ли элемент в списке

    void remove(int index);
    //удаление элемента по индексу (со смещением элементов влево)

    void sort();
    //сортировка элементов списка по возрастанию

    int[] toArray();
    //возвращает все элементы из списка в виде массива

    void addAll(IntList list);
    //добавление всех элементов из списка list в данный список (в конец)

    void addAll(IntList list, int index);
    //добавление всех элементов из списка list в данный список начиная с конкретного индекса

}
