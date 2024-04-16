package search.methods;

import java.util.*;

import search.nodes.Edge;
import search.nodes.Graph;
import search.nodes.Node;
import search.nodes.PriorityNode;

public class UniformCost {
    public static List<String> uniformCostSearch(Graph graph, String start, String goal) {
        PriorityQueue<PriorityNode> frontier = new PriorityQueue<>();
        Map<Node, Node> cameFrom = new HashMap<>();
        Map<Node, Integer> costSoFar = new HashMap<>();
        
        Node startNode = graph.getNode(start);
        Node goalNode = graph.getNode(goal);
        
        frontier.add(new PriorityNode(startNode, 0));
        cameFrom.put(startNode, null);
        costSoFar.put(startNode, 0);
        
        while (!frontier.isEmpty()) {
            PriorityNode currentPriorityNode = frontier.poll();
            Node current = currentPriorityNode.getNode();

            if (current.equals(goalNode)) {
                return reconstructPath(cameFrom, startNode, goalNode);
            }

            for (Edge edge : current.getEdges()) {
                Node next = edge.getDestination();
                int newCost = costSoFar.get(current) + edge.getCost();
                if (!costSoFar.containsKey(next) || newCost < costSoFar.get(next)) {
                    costSoFar.put(next, newCost);
                    frontier.add(new PriorityNode(next, newCost));
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
}
