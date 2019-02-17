package com.company;

public class Node {
    private Node tail;
    private char value;

    Node(char value, Node tail) {
        this.value = value;
        this.tail = tail;
    }

    Node getTail() {
        return tail;
    }

    char getValue() {
        return value;
    }

    boolean hasNext() {
        return tail!= null;
    }
}