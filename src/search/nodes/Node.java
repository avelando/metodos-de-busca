package search.nodes;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Node {
    private String name;
    private int heuristic;
    private List<Edge> edges;
    public Node(String name, int heuristic) {
        this.name = name;
        this.heuristic = heuristic;
        this.edges = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getHeuristic() {
        return heuristic;
    }

    public void addEdge(Edge edge) {
        edges.add(edge);
    }

    public List<Edge> getEdges() {
        return new ArrayList<>(edges);
    }

    public List<Node> getNeighbors() {
        return edges.stream().map(Edge::getDestination).collect(Collectors.toList());
    }
}
