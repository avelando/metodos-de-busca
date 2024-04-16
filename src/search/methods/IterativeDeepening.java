package search.methods;

import search.nodes.*;

import java.util.*;

public class IterativeDeepening {
    public static List<String> iterativeDeepeningSearch(Graph graph, String start, String goal) {
        for (int depth = 0; depth < Integer.MAX_VALUE; depth++) {
            List<String> path = depthLimitedSearch(graph, start, goal, depth);
            if (path != null) {
                return path; // Retorna o caminho se o objetivo for encontrado
            }
        }
        return Collections.emptyList(); // Retorna uma lista vazia se o objetivo não for encontrado
    }

    private static List<String> depthLimitedSearch(Graph graph, String start, String goal, int limit) {
        Node startNode = graph.getNode(start);
        Node goalNode = graph.getNode(goal);
        Set<Node> visited = new HashSet<>();
        List<String> path = new ArrayList<>();
        
        boolean found = depthLimitedRecursive(startNode, goalNode, limit, visited, path, 0);
        if (found) {
            Collections.reverse(path);  // O caminho está em ordem inversa devido à recursão
            return path;
        }
        return null; // Retorna nulo se o objetivo não for encontrado neste limite de profundidade
    }

    private static boolean depthLimitedRecursive(Node current, Node goal, int limit, Set<Node> visited, List<String> path, int depth) {
        if (depth > limit) { // Verifica se o limite de profundidade foi atingido
            return false;
        }
        
        visited.add(current);
        
        if (current.equals(goal)) {
            path.add(current.getName());
            return true;
        }

        for (Edge edge : current.getEdges()) {
            Node next = edge.getDestination();
            if (!visited.contains(next)) {
                boolean found = depthLimitedRecursive(next, goal, limit, visited, path, depth + 1);
                if (found) {
                    path.add(current.getName());
                    return true;
                }
            }
        }
        
        visited.remove(current);
        return false;
    }
}
