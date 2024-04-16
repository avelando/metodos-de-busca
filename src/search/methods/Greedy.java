package search.methods;

import search.nodes.*;

import java.util.*;

public class Greedy {

    public static List<String> greedySearch(Graph graph, String start, String goal) {
        PriorityQueue<PriorityNode> frontier = new PriorityQueue<>(Comparator.comparingInt(n -> n.getNode().getHeuristic()));
        Map<Node, Node> cameFrom = new HashMap<>();
        Node startNode = graph.getNode(start);
        Node goalNode = graph.getNode(goal);

        frontier.add(new PriorityNode(startNode, startNode.getHeuristic()));
        cameFrom.put(startNode, null);

        while (!frontier.isEmpty()) {
            Node current = frontier.poll().getNode();

            if (current.equals(goalNode)) {
                return reconstructPath(cameFrom, startNode, goalNode);
            }

            for (Edge edge : current.getEdges()) {
                Node next = edge.getDestination();
                if (!cameFrom.containsKey(next)) {
                    frontier.add(new PriorityNode(next, next.getHeuristic()));
                    cameFrom.put(next, current);
                }
            }
        }

        return Collections.emptyList(); // Retorna uma lista vazia se o objetivo não for encontrado
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
}
