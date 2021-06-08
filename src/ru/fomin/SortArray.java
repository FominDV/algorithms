package ru.fomin;

import java.util.Arrays;
import java.util.Random;

public class SortArray {

    public static void main(String[] args) {
        int[] arr = getIntegerArray(10);
        System.out.println("before sorting: " + Arrays.toString(arr));
        sortArr(arr);
        System.out.println("after sorting: " + Arrays.toString(arr));

    }

    private static int[] getIntegerArray(int countElements) {
        Random random = new Random(System.currentTimeMillis());
        int[] arr = new int[countElements];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt();
        }
        return arr;
    }

    /**
     * Пузырьковая сортировка с улучшениями.
     */
    private static void sortArr(int[] arr) {
        boolean isSwapped = false;
        int boundOfSorting = arr.length - 1;
        int bufferBoundOfSorting = boundOfSorting;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < boundOfSorting; j++) {
                if (arr[j] > arr[j + 1]) {
                    arr[j + 1] += arr[j];
                    arr[j] = arr[j + 1] - arr[j];
                    arr[j + 1] -= arr[j];
                    isSwapped = true;
                    bufferBoundOfSorting = j;
                }
            }
            if (!isSwapped) {
                return;
            }
            boundOfSorting = bufferBoundOfSorting;
            isSwapped = false;
        }
    }

}
