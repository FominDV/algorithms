package ru.fomin.graph2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    private static Integer[][] matrix = {
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

    public static void main(String[] args) {

        //создаём и заполняем граф
        Graph graph = new Graph();
        for (int i = 0; i < matrix.length; i++) {
            List<Integer[]> vertexInfoList = new ArrayList<>();
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == null) {
                    continue;
                }
                Integer[] vertexInfo = new Integer[2];
                vertexInfo[0] = j + 1;
                vertexInfo[1] = matrix[i][j];
                vertexInfoList.add(vertexInfo);
            }
            graph.addVertex(i + 1, vertexInfoList);
        }

        List<Graph.Vertex> vertexList = graph.getMinPath(8, 12);
        String path = vertexList.stream()
                .map(vertex -> vertex.getName().toString())
                .collect(Collectors.joining(" -> "));
        System.out.print("path: " + path + "\nLength: " + graph.getPathLength(vertexList));

    }

}
