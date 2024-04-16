package search.methods;

import search.nodes.*;

import java.util.*;

public class AStar {
    public static List<String> aStarSearch(Graph graph, String start, String goal) {
        PriorityQueue<PriorityNode> frontier = new PriorityQueue<>();
        Map<Node, Node> cameFrom = new HashMap<>();
        Map<Node, Integer> costSoFar = new HashMap<>();
        Node startNode = graph.getNode(start);
        Node goalNode = graph.getNode(goal);

        frontier.add(new PriorityNode(startNode, 0));
        cameFrom.put(startNode, null);
        costSoFar.put(startNode, 0);

        while (!frontier.isEmpty()) {
            Node current = frontier.poll().getNode();

            if (current.equals(goalNode)) {
                return reconstructPath(cameFrom, startNode, goalNode);
            }

            for (Edge edge : current.getEdges()) {
                Node next = edge.getDestination();
                int newCost = costSoFar.get(current) + edge.getCost();
                if (!costSoFar.containsKey(next) || newCost < costSoFar.get(next)) {
                    costSoFar.put(next, newCost);
                    int priority = newCost + next.getHeuristic();
                    frontier.add(new PriorityNode(next, priority));
                    cameFrom.put(next, current);
                }
            }
        }

        return Collections.emptyList(); 
    }

    private static List<String> reconstructPath(Map<Node, Node> cameFrom, Node start, Node goal) {
        List<String> path = new ArrayList<>();
        Node current = goal;

        while (current != null) {
            path.add(current.getName());
            current = cameFrom.get(current);
        }

        Collections.reverse(path);
        return path;
    }

    private static class PriorityNode implements Comparable<PriorityNode> {
        private final Node node;
        private final int priority;

        public PriorityNode(Node node, int priority) {
            this.node = node;
            this.priority = priority;
        }

        public Node getNode() {
            return node;
        }

        @Override
        public int compareTo(PriorityNode other) {
            return Integer.compare(this.priority, other.priority);
        }
    }
}
