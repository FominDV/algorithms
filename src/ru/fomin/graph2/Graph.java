package ru.fomin.graph2;

import java.util.*;
import java.util.stream.Collectors;

public class Graph {

    private List<Vertex> vertexList = new ArrayList<>();

    /**
     * Добавить вершину.
     *
     * @param name               - имя вершины
     * @param adjacentVertexList - массив вектора длиной 2, где 0-ой элемент - это имя смежной вершины, а 1-ый это вес ребра
     */
    public void addVertex(Integer name, List<Integer[]> adjacentVertexList) {
        Vertex vertex = getVertex(name);
        for (Integer[] vertexInfo : adjacentVertexList) {
            vertex.addAdjacentVertex(getVertex(vertexInfo[0]), vertexInfo[1]);
        }

        vertexList.add(vertex);
    }

    public Integer getPathLength(List<Vertex> vertexList) {
        Integer length = 0;
        for (int i = 0; i < vertexList.size() - 1; i++) {
            length += vertexList.get(i).getLengthToVertex(vertexList.get(i + 1));
        }
        return length;
    }

    public List<Vertex> getMinPath(Integer vertexName1, Integer vertexName2) {
        return getMinPath(getVertex(vertexName1), getVertex(vertexName2), new ArrayList<>());
    }

    private Vertex getVertex(Integer name) {
        return vertexList.stream()
                .filter(vertex -> vertex.getName().equals(name))
                .findFirst()
                .orElseGet(() -> {
                    Vertex vertex = new Vertex(name);
                    vertexList.add(vertex);
                    return vertex;
                });
    }

    private List<Vertex> getMinPath(Vertex vertex1, Vertex vertex2, List<Vertex> inVisitedVertexList) {
       ArrayList<Vertex> visitedVertexList = new ArrayList<>(inVisitedVertexList);
       visitedVertexList.add(vertex1);

        if (vertex1.hasPathToVertex(vertex2)) {
            visitedVertexList.add(vertex2);
            return visitedVertexList;
        }

        Integer minPathLength = Integer.MAX_VALUE;
        List<Vertex> newVisitedVertexList = null;

        for (Vertex vertex : vertex1.getAdjacentVertexes(visitedVertexList)) {
            List<Vertex> currentVisitedVertexList = getMinPath(vertex, vertex2, visitedVertexList);
            if (currentVisitedVertexList != null) {
                Integer currentPathLength = getPathLength(currentVisitedVertexList);
                if (minPathLength > currentPathLength) {
                    minPathLength = currentPathLength;
                    newVisitedVertexList = new ArrayList<>(currentVisitedVertexList);
                }
            }
        }

        return newVisitedVertexList;
    }

    static class Vertex {

        private Integer name;
        private Map<Vertex, Integer> adjacentVertexMap;

        public Vertex(Integer name) {
            this.name = name;
            adjacentVertexMap = new HashMap<>();
        }

        public Integer getName() {
            return name;
        }

        public Integer getLengthToVertex(Vertex vertex) {
            return adjacentVertexMap.get(vertex);
        }

        public boolean hasPathToVertex(Vertex vertex) {
            return adjacentVertexMap.containsKey(vertex);
        }

        public void addAdjacentVertex(Vertex vertex, Integer length) {
            adjacentVertexMap.put(vertex, length);
        }

        public List<Vertex> getAdjacentVertexes(List<Vertex> excludeVertexList) {
            return adjacentVertexMap.keySet()
                    .stream()
                    .filter(vertex -> !excludeVertexList.contains(vertex))
                    .collect(Collectors.toList());
        }

        @Override
        public int hashCode() {
            return name.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            return name.equals(((Vertex) obj).getName());
        }
    }

}
