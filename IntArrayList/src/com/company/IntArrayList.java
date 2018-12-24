package com.company;

public class IntArrayList implements IntList {
    private static final int DEFAULT_CAPACITY = 10;
    private int[] elements;
    private int count = 0;
    private static final double EXTENSION_COEF = 1.5;

    public IntArrayList() {
        this.elements = new int[DEFAULT_CAPACITY];
    }

    @Override
    public void add(int e) {
        if (count == elements.length) {
            grow();
        }
        elements[count++] = e;
    }

    private void grow() {
        int oldCapacity = elements.length;
        int newCapacity = (int) (oldCapacity * EXTENSION_COEF);
        int[] newElements = new int[newCapacity];
        for (int i = 0; i < oldCapacity; i++) {
            newElements[i] = elements[i];
        }
        elements = newElements;
    }

    @Override
    public int get(int index) {
        if (index < 0 || index >= count){
            throw new IllegalArgumentException("Index: " + index + " is not valid");
        }
        return elements[index];
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public boolean contains(int value) {
        for(int e : elements) {
            if( e == value) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void remove(int index) {
        for (int i = index; i <count-1; i++) {
            elements[i] = elements[i+1];
        }
        count--;
    }

    @Override
    public void sort() {
        boolean wasChangedOnLastIteration = true;
        for (int i = 0; i < count & wasChangedOnLastIteration; i++) {
            wasChangedOnLastIteration = false;
            for (int j = 0; j < count - 1 - i; j++) {
                if (elements[j] > elements[j + 1]) {
                    int buf = elements[j];
                    elements[j] = elements[j + 1];
                    elements[j + 1] = buf;
                    wasChangedOnLastIteration = true;
                }
            }
        }
    }

    @Override
    public int[] toArray() {
        int[] newMas = new int[count];
        for (int i = 0; i <count; i++) {
            newMas[i] = elements[i];
        }
        return newMas;
    }

    @Override
    public void addAll(IntList list) {
        addAll(list, 0);
    }

    @Override
    public void addAll(IntList list, int index) {
        int newcount = count;
        int newSize = (count + list.size() - index);
        int[] newArray = new int[(int) (newSize * EXTENSION_COEF)];
        for(int i = 0; i < count; i++) {
            newArray[i] = elements[i];
        }
        for(int i = index; i < list.size(); i++) {
            newArray[newcount++] = list.get(i);
        }
        elements = newArray;
    }
}