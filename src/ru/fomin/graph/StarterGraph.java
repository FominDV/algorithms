package ru.fomin.graph;

public class StarterGraph {

    public static void main(String[] args) {
        Graph graph = new Graph(getAdjacencyMatrix());

    }

    private static Integer[][] getAdjacencyMatrix(){
        return new Integer[][]{
                {null,5,null,null,null,null,null,8,9,null,null,null,3},
                {5,null,null,8,null,21,24,16,null,null,null,null,7},
                {null,null,null,null,2,5,6,22,3,null,5,null,11},
                {null,8,null,null,9,null,null,null,null,null,null,null,15},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
        }
    }

}
