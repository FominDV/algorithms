package ru.fomin.queue;

import java.util.Arrays;
import java.util.Random;

public class StarterQueue {

    public static void main(String[] args) {
        int[] arr = getIntegerArray(10);
        System.out.println("Array: " + Arrays.toString(arr));
        Queue queue = new Queue();

        /*Заносим в очередь значения массива по убыванию,
         * меняя знак у уже занесённых элементов на противоположенный.*/
        for (int i = 0; i < arr.length; i++) {
            int indexOfMax = getIndexOfMax(arr);
            queue.put(arr[indexOfMax]);
            System.out.printf("Value %d was put into the queue. Queue is already filled: %s\n", arr[indexOfMax], queue.isFilled());
            arr[indexOfMax] *= -1;
        }
        System.out.println();

        /*Возвращает элементы из очереди,
         * пока очередь не опустеет.*/
        while (!queue.isEmpty()) {
            int valueFromQueue = queue.pop();
            System.out.printf("Value from queue: %d. Queue is empty: %s\n", valueFromQueue, queue.isEmpty());
        }

    }

    private static int[] getIntegerArray(int countElements) {
        Random random = new Random(System.currentTimeMillis());
        int[] arr = new int[countElements];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100);
        }
        return arr;
    }

    /**
     * Возвращаем индекс максимального элемента.
     */
    private static int getIndexOfMax(int[] arr) {
        int indexMax = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[indexMax] < arr[i]) {
                indexMax = i;
            }
        }
        return indexMax;
    }

}
