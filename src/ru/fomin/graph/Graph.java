package ru.fomin.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Неориентрированный взвешанный граф.
 */
public class Graph {

    //матрица смежности
    private Integer[][] matrix;

    public Graph(Integer[][] matrix) {
        this.matrix = matrix;
    }

    /**
     * Возвращает минимальный путь между вершинами графа в виде списка пройденных вершин.
     * Нумерация вершин начинается с 1.
     *
     * @param vertex1 - первая вершина
     * @param vertex2 - вторая вершина
     */
    public List<Integer> getMinWay(Integer vertex1, Integer vertex2) {
        if (vertex1 < 1 || vertex2 < 1 || vertex1 == vertex2) {
            throw new IndexOutOfBoundsException("недопустимые значения вершин графа");
        }
        return getMinWay(--vertex1, --vertex2, new ArrayList<>());
    }

    /**
     * Возвращает минимальный путь между вершинами графа в виде списка пройденных вершин.
     * Нумерация вершин начинается с 0.
     *
     * @param from       - вершина отправления, отсутствует в списке пройденных вершин
     * @param target     - вершина назначения
     * @param vertexList - пройденные вершины
     * @return - null, если отсутствуют непосещённые вершины
     */
    private List<Integer> getMinWay(Integer from, Integer target, List<Integer> vertexList) {
        vertexList.add(from);
        Integer[] vertexWays = matrix[from];
        int minWayLength = Integer.MAX_VALUE;
        List<Integer> newVertexList = null;

        for (int i = 0; i < vertexWays.length; i++) {

            /*Проверяется, что данное ребро существует,
             * и что данный узел ещё не был посещён.*/
            if (vertexWays[i] == null || vertexList.contains(i)) {
                continue;
            }

            //проверяем, является ли данный узел пунктом назначения
            if (i == target) {
                vertexList.add(i);
                newVertexList = new ArrayList<>(vertexList);
                break;
            }

            List<Integer> vertexListOfCurrentVertex = getMinWay(i, target, new ArrayList<>(vertexList));
            if (vertexListOfCurrentVertex == null) {
                continue;
            }
            int wayLength = getWayLength(vertexListOfCurrentVertex);
            if (wayLength < minWayLength) {
                minWayLength = wayLength;
                newVertexList = vertexListOfCurrentVertex;
            }
        }
        return newVertexList;
    }

    /**
     * Возвращает длину пути по списку пройденных узлов.
     */
    public int getWayLength(List<Integer> vertexList) {
        int wayLength = 0;
        for (int i = 1; i < vertexList.size(); i++) {
            wayLength += matrix[vertexList.get(i - 1)][vertexList.get(i)];
        }
        return wayLength;
    }

}
