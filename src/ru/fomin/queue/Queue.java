package ru.fomin.queue;

/**
 * Очередь.
 */
public class Queue {

    private int[] array = new int[10];
    private int head = 0;
    private int tail = 0;
    private int countElements; // заполненность всех элементов очереди

    /**
     * Добавить элемент в очередь.
     *
     * @return - true если элемент успешно добавлен
     */
    public boolean put(int value) {
        if (isFilled()) {
            return false;
        }
        array[tail] = value;
        tail = tail == array.length - 1 ? 0 : ++tail;
        countElements++;
        return true;
    }

    /**
     * Извлечь элемент из очереди.
     *
     * @return - null, если очередь пуста
     */
    public Integer pop() {
        if (isEmpty()) {
            return null;
        }
        int value = array[head];
        head = head == array.length - 1 ? 0 : ++head;
        countElements--;
        return value;
    }

    /**
     * Проверяет заполнена ли очередь до предела.
     */
    public boolean isFilled() {
        return countElements == array.length;
    }

    public boolean isEmpty() {
        return countElements == 0;
    }

}
