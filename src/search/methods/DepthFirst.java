package search.methods;

import java.util.*;

import search.nodes.Graph;
import search.nodes.Node;

public class DepthFirst {
    public static List<String> depthFirstSearch(Graph graph, String start, String goal) {
        Node startNode = graph.getNode(start);
        Node goalNode = graph.getNode(goal);
        List<String> path = new ArrayList<>();
        Set<Node> visited = new HashSet<>();
        
        boolean found = depthFirstRecursive(startNode, goalNode, visited, path);
        if (found) {
            return path;
        } else {
            return Collections.emptyList();
        }
    }

    private static boolean depthFirstRecursive(Node current, Node goal, Set<Node> visited, List<String> path) {
        visited.add(current);

        if (current.equals(goal)) {
            path.add(current.getName()); 
            return true; 
        }

        for (Node neighbor : current.getNeighbors()) {
            if (!visited.contains(neighbor)) {
                boolean found = depthFirstRecursive(neighbor, goal, visited, path);
                if (found) {
                    path.add(0, current.getName());
                    return true;
                }
            }
        }

        return false;
    }
}
