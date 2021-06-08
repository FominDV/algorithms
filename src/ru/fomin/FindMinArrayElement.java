package ru.fomin;

import java.util.Arrays;
import java.util.Random;

public class FindMinArrayElement {

    public static void main(String[] args) {
        int[] arr = getIntegerArray(10);
        System.out.println("Array: " + Arrays.toString(arr));
        int indexMinValue = getIndexOfMinElement(arr);
        System.out.printf("Min value: %d\nIndex of min value: %d", arr[indexMinValue], indexMinValue);
    }

    private static int[] getIntegerArray(int countElements) {
        Random random = new Random(System.currentTimeMillis());
        int[] arr = new int[countElements];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(200) - 100;
        }
        return arr;
    }

    /**
     * Возвращает индекс минимального элемента массива.
     */
    private static int getIndexOfMinElement(int[] arr) {
        int indexOfMinElement = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[indexOfMinElement] > arr[i]) {
                indexOfMinElement = i;
            }
        }
        return indexOfMinElement;
    }

}
