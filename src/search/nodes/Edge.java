package search.nodes;

public class Edge {
    private final Node destination;
    private final int cost;

    public Edge(Node destination, int cost) {
        this.destination = destination;
        this.cost = cost;
    }

    public Node getDestination() {
        return destination;
    }

    public int getCost() {
        return cost;
    }
}
