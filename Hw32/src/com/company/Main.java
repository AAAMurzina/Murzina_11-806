package com.company;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class LinkedListWithStream<T> implements Iterable<T> {
    private Node<T> head;
    private int count = 0;

    public void add(T value) {
        Node<T> newNode = new Node<>(value);
        if (head != null) {
            Node<T> current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        } else {
            head = newNode;
        }
        count++;
    }

    public T get(int index) {
        if (index < 0 || index >= count)
            throw new IndexOutOfBoundsException("Index: " + index);
        else {
            Node<T> elem = head;
            for (int i = 0; i < index; i++) {
                elem = elem.getNext();
            }
            return elem.getValue();
        }
    }

    public void remove(int index) {
        if (index < 0 || index >= count)
            throw new IndexOutOfBoundsException("Index: " + index);
        else if (index == 0) {
            head = head.getNext();
        } else {
            Node<T> beforeElem = head;
            for (int i = 0; i < index - 1; i++) {
                beforeElem = beforeElem.getNext();
            }
            beforeElem.setNext(beforeElem.getNext().getNext());
        }
        count--;
    }

    public boolean contains(T value) {
        Node<T> current = head;
        while (current.hasNext()) {
            if (current.getValue() == value)
                return true;
            current = current.getNext();
        }
        return false;
    }

    public Object[] toArray() {
        Object[] arr = new Object[count];
        Node<T> node = head;
        for (int i = 0; i < count; i++) {
            arr[i] = node.getValue();
            node = node.getNext();
        }
        return arr;
    }

    private Node<T> getTail() {
        if (head == null) return null;
        Node<T> node = head;
        while (node.hasNext()) {
            node = node.getNext();
        }
        return node;
    }

    public void addAll(LinkedListWithStream<T> list) {
        if (list.size() == 0) return;
        Node<T> tail = getTail();
        if (tail == null) {
            tail = new Node<>(list.get(0));
            head = tail;
            if (list.size() > 1) {
                Iterator<T> iterator = list.iterator();
                iterator.next();
                for (T t : list) {
                    tail.setNext(tail = new Node<>(t));
                }
            }
        } else {
            Node<T> n = tail;
            for (T k : list) {
                n.setNext(n = new Node<>(k));
            }
        }

    }

    public int size() {
        return count;
    }

    @Override
    public Iterator<T> iterator() {
        Iterator<T> iterator = new Iterator<T>() {
            Node<T> current = head;

            @Override
            public boolean hasNext() {
                return current.hasNext();
            }

            @Override
            public T next() {
                current = current.getNext();
                return current.getValue();
            }
        };
        return iterator;
    }


    class Node<E> {
        private Node<E> next;
        private E value;

        Node(E value) {
            this.value = value;
        }

        void setNext(Node<E> next) {
            this.next = next;
        }

        Node<E> getNext() {
            return next;
        }

        E getValue() {
            return value;
        }

        boolean hasNext() {
            return next != null;
        }
    }

    public Stream<T> stream() {
        return new MyStream();
    }

    public class MyStream implements Stream<T> {

        @Override
        public Stream<T> filter(Predicate<? super T> predicate) {
            LinkedListWithStream<T> newList = new LinkedListWithStream<>();
            for (int i = 0; i <size() ; i++) {
                if (predicate.test(get(i))) {
                    newList.add(get(i));
                }
            }
            return newList.stream();
        }

        @Override
        public <R> Stream<R> map(Function<? super T, ? extends R> mapper) {
            LinkedListWithStream<R> newList = new LinkedListWithStream<>();
            for (int i = 0; i <size() ; i++) {
                newList.add(mapper.apply(get(i)));
            }
            return newList.stream();
        }

        @Override
        public void forEach(Consumer<? super T> action) {
            for (int i = 0; i <size() ; i++) {
                action.accept(get(i));
            }
        }

        @Override
        public IntStream mapToInt(ToIntFunction<? super T> mapper) {
            return null;
        }

        @Override
        public LongStream mapToLong(ToLongFunction<? super T> mapper) {
            return null;
        }

        @Override
        public DoubleStream mapToDouble(ToDoubleFunction<? super T> mapper) {
            return null;
        }

        @Override
        public <R> Stream<R> flatMap(Function<? super T, ? extends Stream<? extends R>> mapper) {
            return null;
        }

        @Override
        public IntStream flatMapToInt(Function<? super T, ? extends IntStream> mapper) {
            return null;
        }

        @Override
        public LongStream flatMapToLong(Function<? super T, ? extends LongStream> mapper) {
            return null;
        }

        @Override
        public DoubleStream flatMapToDouble(Function<? super T, ? extends DoubleStream> mapper) {
            return null;
        }

        @Override
        public Stream<T> distinct() {
            return null;
        }

        @Override
        public Stream<T> sorted() {
            return null;
        }

        @Override
        public Stream<T> sorted(Comparator<? super T> comparator) {
            return null;
        }

        @Override
        public Stream<T> peek(Consumer<? super T> action) {
            return null;
        }

        @Override
        public Stream<T> limit(long maxSize) {
            return null;
        }

        @Override
        public Stream<T> skip(long n) {
            return null;
        }


        @Override
        public void forEachOrdered(Consumer<? super T> action) {

        }

        @Override
        public Object[] toArray() {
            return new Object[0];
        }

        @Override
        public <A> A[] toArray(IntFunction<A[]> generator) {
            return null;
        }

        @Override
        public T reduce(T identity, BinaryOperator<T> accumulator) {
            return null;
        }

        @Override
        public Optional<T> reduce(BinaryOperator<T> accumulator) {
            return Optional.empty();
        }

        @Override
        public <U> U reduce(U identity, BiFunction<U, ? super T, U> accumulator, BinaryOperator<U> combiner) {
            return null;
        }

        @Override
        public <R> R collect(Supplier<R> supplier, BiConsumer<R, ? super T> accumulator, BiConsumer<R, R> combiner) {
            return null;
        }

        @Override
        public <R, A> R collect(Collector<? super T, A, R> collector) {
            return null;
        }

        @Override
        public Optional<T> min(Comparator<? super T> comparator) {
            return Optional.empty();
        }

        @Override
        public Optional<T> max(Comparator<? super T> comparator) {
            return Optional.empty();
        }

        @Override
        public long count() {
            return 0;
        }

        @Override
        public boolean anyMatch(Predicate<? super T> predicate) {
            return false;
        }

        @Override
        public boolean allMatch(Predicate<? super T> predicate) {
            return false;
        }

        @Override
        public boolean noneMatch(Predicate<? super T> predicate) {
            return false;
        }

        @Override
        public Optional<T> findFirst() {
            return Optional.empty();
        }

        @Override
        public Optional<T> findAny() {
            return Optional.empty();
        }

        @Override
        public Iterator<T> iterator() {
            return null;
        }

        @Override
        public Spliterator<T> spliterator() {
            return null;
        }

        @Override
        public boolean isParallel() {
            return false;
        }

        @Override
        public Stream<T> sequential() {
            return null;
        }

        @Override
        public Stream<T> parallel() {
            return null;
        }

        @Override
        public Stream<T> unordered() {
            return null;
        }

        @Override
        public Stream<T> onClose(Runnable closeHandler) {
            return null;
        }

        @Override
        public void close() {

        }
    }

}