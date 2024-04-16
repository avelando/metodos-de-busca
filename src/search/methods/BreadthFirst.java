package search.methods;

import java.util.*;

import search.nodes.Graph;
import search.nodes.Node;

public class BreadthFirst {
    public static List<String> breadthFirstSearch(Graph graph, String start, String goal) {
        Queue<Node> queue = new LinkedList<>();
        Map<Node, Node> cameFrom = new HashMap<>();
        Node startNode = graph.getNode(start);
        Node goalNode = graph.getNode(goal);

        queue.add(startNode);
        cameFrom.put(startNode, null);

        while (!queue.isEmpty()) {
            Node current = queue.remove();

            if (current.equals(goalNode)) {
                return reconstructPath(cameFrom, startNode, goalNode, "Busca em largura");
            }

            for (Node neighbor : current.getNeighbors()) {
                if (!cameFrom.containsKey(neighbor)) {
                    queue.add(neighbor);
                    cameFrom.put(neighbor, current);
                }
            }
        }

        return Collections.emptyList();
    }

    private static List<String> reconstructPath(Map<Node, Node> cameFrom, Node start, Node goal, String methodName) {
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
