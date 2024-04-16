package search.nodes;

import java.util.HashMap;
import java.util.Map;

public class Graph {
    private Map<String, Node> nodes = new HashMap<>();

    public void addNode(String name, int heuristic) {
        nodes.put(name, new Node(name, heuristic));
    }

    public void addEdge(String srcName, String destName, int distance) {
        Node src = nodes.get(srcName);
        Node dest = nodes.get(destName);
        if (src != null && dest != null) {
            src.addEdge(new Edge(dest, distance));
            dest.addEdge(new Edge(src, distance)); 
        }
    }

    public Node getNode(String name) {
        return nodes.get(name);
    }

    public Map<String, Node> getAllNodes() {
        return nodes;
    }
}
