package ru.fomin.tree;

import java.util.Arrays;
import java.util.Random;

public class StarterTree {

    public static void main(String[] args) {
        int[] arr = getIntegerArray(15);
        System.out.println("Array: " + Arrays.toString(arr));

        //Создаём и заполняем дерево неупорядоченным массивом
        BinaryTree binaryTree = new BinaryTree();
        for (int value: arr) {
            binaryTree.put(value);
        }

        /*Получаем упорядоченный по возрастанию массив из элементов дерева*/
        int[] sortedArr = binaryTree.getSortedValues();
        System.out.println("Sorted array from binary tree:\n" + Arrays.toString(sortedArr));
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
