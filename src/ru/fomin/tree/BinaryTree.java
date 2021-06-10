package ru.fomin.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Двоичное упорядоченное дерево.
 */
public class BinaryTree {

    //Корень дерева
    private Node root;

    /**
     * Добавляет элемент в дерево.
     */
    public void put(int value) {
        if (root == null) {
            root = new Node(value);
            return;
        }
        root.put(value);
    }

    /**
     * Возвращает упорядоченный по возрастанию массив элементов дерева.
     */
    public int[] getSortedValues() {
        if (root == null) {
            throw new RuntimeException("в дереве отсутствуют элементы");
        }
        return root.getSortedValues().stream()
                .mapToInt(Integer::valueOf)
                .toArray();
    }

    /**
     * Узел дерева
     */
    private static class Node {
        private Node parent;
        private Node rightChild;
        private Node leftChild;
        private int value;

        public Node(int value) {
            this.value = value;
        }

        Node(Node parent, int value) {
            this.parent = parent;
            this.value = value;
        }

        /**
         * Добавляет элемент в дерево.
         */
        public void put(int value) {
            if (value < this.value) {
                addToLeft(value);
            } else {
                addToRight(value);
            }
        }

        /**
         * Возвращает упорядоченный по возрастанию список элементов дерева.
         */
        public List<Integer> getSortedValues() {
            List<Integer> sortedValues = new ArrayList<>();
            if (leftChild != null) {
                sortedValues.addAll(leftChild.getSortedValues());
            }
            sortedValues.add(value);
            if (rightChild != null) {
                sortedValues.addAll(rightChild.getSortedValues());
            }
            return sortedValues;
        }

        private void addToLeft(int value) {
            if (leftChild == null) {
                leftChild = new Node(this, value);
                return;
            }
            leftChild.put(value);
        }

        private void addToRight(int value) {
            if (rightChild == null) {
                rightChild = new Node(this, value);
                return;
            }
            rightChild.put(value);
        }

    }

}
