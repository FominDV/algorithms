package ru.fomin.stack;

import java.util.Arrays;
import java.util.Random;

public class StarterStack {

    public static void main(String[] args) {
        int[] arr = getIntegerArray(10);
        System.out.println("Array: " + Arrays.toString(arr));
        Stack stack = new Stack();

        //Занесение элементов массива в стек
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("Put value %d into the stack\n", arr[i]);
            stack.put(arr[i]);
        }

        //Извлечение элементов массива из стека
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("Gotten value from the stack: %d\n", stack.pop());
        }
    }

    private static int[] getIntegerArray(int countElements) {
        Random random = new Random(System.currentTimeMillis());
        int[] arr = new int[countElements];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(200) - 100;
        }
        return arr;
    }

}
