package test.drivers.graph;

import algorithm.graph.CycleDetectorWithDisjointSet;
import interfaces.graph.CycleDetector;
import model.Graph;

public class GraphDriver {
    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);
        CycleDetector cycleDetector = new CycleDetectorWithDisjointSet(graph);
        System.out.println("Is graph cyclic : " + cycleDetector.isCyclic());
    }
}
