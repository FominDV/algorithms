package ru.fomin.stack;

import java.util.NoSuchElementException;

/**
 * Стек.
 */
public class Stack {

    int[] array = new int[10];
    int currentIndex = 0;

    /**
     * Добавить элемент в стек.
     */
    public void put(int value) {
        if (currentIndex == array.length) {
            throw new IndexOutOfBoundsException("стек переполнен");
        }
        array[currentIndex++] = value;
    }

    /**
     * Достать элемент из стека.
     */
    public int pop() {
        if (currentIndex == 0) {
            throw new NoSuchElementException("в стеке нет элементов");
        }
        return array[--currentIndex];
    }

}
