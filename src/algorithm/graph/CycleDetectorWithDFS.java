package algorithm.graph;

import interfaces.graph.CycleDetector;
import model.Graph;

public class CycleDetectorWithDFS implements CycleDetector {

    private Graph graph;

    public CycleDetectorWithDFS(Graph graph) {
        this.graph = graph;
    }

    public boolean isCyclic() {
        boolean[] visited = new boolean[graph.getTotalVertices()];
        boolean[] recursionStack = new boolean[graph.getTotalVertices()];
        for (int vertex = 0; vertex < graph.getTotalVertices(); vertex++) {
            if(isCyclicUtil(vertex, visited, recursionStack)) {
                return true;
            }
        }
        return false;
    }

    private boolean isCyclicUtil(int vertex, boolean[] visited, boolean[] recursionStack) {
        if (recursionStack[vertex]) {
            return true;
        }

        if (visited[vertex]) {
            return false;
        }

        visited[vertex] = true;
        recursionStack[vertex] = true;

        for (Integer child : graph.getChildren(vertex)) {
            if (isCyclicUtil(child, visited, recursionStack)) {
                return true;
            }
        }

        recursionStack[vertex] = false;

        return false;
    }
}
