package ru.fomin.graph;

import java.util.List;

public class StarterGraph {

    public static void main(String[] args) {
        Integer[][] adjacencyMatrix = getAdjacencyMatrix();
        printMatrix(adjacencyMatrix);
        Graph graph = new Graph(adjacencyMatrix);
        List<Integer> vertexesOfMinWay = graph.getMinWay(8, 12);
        printWay(vertexesOfMinWay);
        System.out.println("Length of way: " + graph.getWayLength(vertexesOfMinWay));
    }

    /**
     * Выводит в консоль путь в виде последовательности вершин.
     */
    private static void printWay(List<Integer> vertexList) {
        System.out.println("Full way:");
        for (int i = 0; i < vertexList.size(); i++) {
            System.out.print(vertexList.get(i) + 1);
            if (i != vertexList.size() - 1) {
                System.out.print(" -> ");
            }
        }
        System.out.println();
    }

    private static Integer[][] getAdjacencyMatrix() {
        return new Integer[][]{
                {null, 5, null, null, null, null, null, 8, 9, null, null, null, 3},
                {5, null, null, 8, null, 21, 24, 16, null, null, null, null, 7},
                {null, null, null, null, 2, 5, 6, 22, 3, null, 5, null, 11},
                {null, 8, null, null, 9, null, null, null, null, null, null, null, 15},
                {null, null, 2, 9, null, null, null, null, null, null, 4, null, 19},
                {null, 21, 5, null, null, null, null, null, 5, null, null, 6, null},
                {null, 24, 6, null, null, null, null, null, 13, 3, null, null, null},
                {8, 16, 22, null, null, null, null, null, 8, null, null, null, null},
                {9, null, 3, null, null, 5, 13, 8, null, null, 9, null, null},
                {null, null, null, null, null, null, 3, null, null, null, null, null, null},
                {null, null, 5, null, 4, null, null, null, 9, null, null, null, null},
                {null, null, null, null, null, 6, null, null, null, null, null, null, null},
                {3, 7, 11, 15, 19, null, null, null, null, null, null, null, null},
        };
    }

    /**
     * Выводит в консоль матрицу смежности
     */
    private static void printMatrix(Integer[][] matrix) {
        System.out.print("     ");
        for (int i = 1; i <= matrix.length; i++) {
            System.out.print(i + "    ");
            if (i < 10) {
                System.out.print(" ");
            }
        }
        System.out.println();
        for (int i = 0; i < matrix.length; i++) {
            System.out.print((i + 1) + "   ");
            if (i < 9) {
                System.out.print(" ");
            }
            for (int j = 0; j < matrix.length; j++) {
                Integer currentValue = matrix[i][j];
                System.out.print(currentValue);
                if (currentValue == null) {
                    System.out.print("  ");
                } else if (currentValue < 10) {
                    System.out.print("     ");
                } else {
                    System.out.print("    ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

}
