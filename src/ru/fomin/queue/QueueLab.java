package ru.fomin.queue;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class QueueLab {

    //исходный массив
    private static Integer[] arr = {56, 12, 44, 99, 345, 1, 45, 1, 90, 33};

    public static void main(String[] args) {
        System.out.println("Исходный массив: " + Arrays.toString(arr));
        Queue<Integer> queue = new PriorityQueue(10);

        /*поочерёдно добавляем по убыванию элементы массива в очередь*/
        Arrays.stream(arr)
                .sorted(Comparator.reverseOrder())
                .forEach(number -> {
                    queue.add(number);
                    System.out.printf("В очередь добавлено значение: %d\n", number);
                });

        //Достаём все элементы из очереди
        while (!queue.isEmpty()) {
            System.out.println("Элемент из очереди: " + queue.poll());
        }
    }

}
