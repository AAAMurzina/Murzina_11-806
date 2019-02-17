package com.company;

public class Queue<T> {
    Node<T> first;
    Node<T> last;

    void enqueue(T elem) {
        Node<T> oldLast = last;
        last = new Node<>();
        last.item = elem;
        if (isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
        }
    }

    T dequeue() {
        if(!isEmpty()){
            T returnable = first.item;
            if(first.next != null){
                first = first.next;
            } else {
                first = null;
            }
            return returnable;
        } else{
            throw new NullPointerException("Queue is empty");

        }
    }

    boolean isEmpty() {
        return first == null;
    }

    class Node<Item> {
        Item item;
        Node<Item> next;
    }
}
