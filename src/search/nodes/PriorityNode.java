package search.nodes;

public class PriorityNode implements Comparable<PriorityNode> {
    private Node node;
    private int pathCost;

    public PriorityNode(Node node, int pathCost) {
        this.node = node;
        this.pathCost = pathCost;
    }

    public Node getNode() {
        return node;
    }

    public int getPathCost() {
        return pathCost;
    }

    @Override
    public int compareTo(PriorityNode other) {
        return Integer.compare(this.pathCost, other.pathCost);
    }
}
