package model;

import interfaces.graph.CycleDetector;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Graph {
    private final int totalVertices;
    private final List<List<Integer>> adj;
    private CycleDetector cycleDetector;

    public Graph(int totalVertices) {
        this.totalVertices = totalVertices;
        this.adj = new ArrayList<>(totalVertices);
        for (int vertex = 0; vertex < totalVertices; vertex++) {
            adj.add(new LinkedList<>());
        }
    }

    public int getTotalVertices() {
        return totalVertices;
    }

    public List<Integer> getChildren(int vertex) {
        return adj.get(vertex);
    }

    public void addEdge(int source, int destination) {
        adj.get(source).add(destination);
    }
}
