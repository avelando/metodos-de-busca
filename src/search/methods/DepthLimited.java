package search.methods;

import search.nodes.*;

import java.util.*;

public class DepthLimited {
    public static List<String> depthLimitedSearch(Graph graph, String start, String goal, int limit) {
        Node startNode = graph.getNode(start);
        Node goalNode = graph.getNode(goal);
        List<String> path = new ArrayList<>();
        Set<Node> visited = new HashSet<>();

        boolean found = depthLimitedRecursive(startNode, goalNode, limit, visited, path);
        if (found) {
            Collections.reverse(path); 
            return path;
        } else {
            return Collections.emptyList(); 
        }
    }

    private static boolean depthLimitedRecursive(Node current, Node goal, int limit, Set<Node> visited, List<String> path) {
        visited.add(current);

        if (current.equals(goal)) {
            path.add(current.getName());
            return true;
        } else if (limit == 0) {
            return false;
        } else {
            for (Edge edge : current.getEdges()) {
                Node next = edge.getDestination();
                if (!visited.contains(next)) {
                    boolean found = depthLimitedRecursive(next, goal, limit - 1, visited, path);
                    if (found) {
                        path.add(current.getName());
                        return true;
                    }
                }
            }
        }
        
        visited.remove(current); 
        return false;
    }
}
