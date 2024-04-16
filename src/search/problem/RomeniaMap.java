package search.problem;

import java.util.HashMap;
import java.util.Map;

import search.nodes.Graph;

public class RomeniaMap {
    private final Graph graph = new Graph();
    private final Map<String, Integer> heuristics = new HashMap<>();

    public RomeniaMap() {
        initializeHeuristics();
        initializeGraph();
    }

    private void initializeHeuristics() {
        heuristics.put("A", 240);
        heuristics.put("B", 186);
        heuristics.put("C", 182);
        heuristics.put("D", 163);
        heuristics.put("E", 170);
        heuristics.put("F", 150);
        heuristics.put("G", 165);
        heuristics.put("H", 139);
        heuristics.put("I", 120);
        heuristics.put("J", 130);
        heuristics.put("K", 122);
        heuristics.put("L", 104);
        heuristics.put("M", 100);
        heuristics.put("N", 77);
        heuristics.put("O", 72);
        heuristics.put("P", 65);
        heuristics.put("Q", 65);
        heuristics.put("R", 0);

        // heuristics.put("Arad", 366);
        // heuristics.put("Bucharest", 0);
        // heuristics.put("Craiova", 160);
        // heuristics.put("Drobeta", 242);
        // heuristics.put("Eforie", 161);
        // heuristics.put("Fagaras", 176);
        // heuristics.put("Giurgiu", 77);
        // heuristics.put("Hirsova", 151);
        // heuristics.put("Iasi", 226);
        // heuristics.put("Lugoj", 244);
        // heuristics.put("Mehadia", 241);
        // heuristics.put("Neamt", 234);
        // heuristics.put("Oradea", 380);
        // heuristics.put("Pitesti", 100);
        // heuristics.put("Rimnicu Vilcea", 193);
        // heuristics.put("Sibiu", 253);
        // heuristics.put("Timisoara", 329);
        // heuristics.put("Urziceni", 80);
        // heuristics.put("Vaslui", 199);
        // heuristics.put("Zerind", 374);
    }

    private void initializeGraph() {
        for (Map.Entry<String, Integer> entry : heuristics.entrySet()) {
            graph.addNode(entry.getKey(), entry.getValue());
        }

        graph.addEdge("A", "B", 73);
        graph.addEdge("A", "C", 64);
        graph.addEdge("A", "D", 89);
        graph.addEdge("A", "E", 104);
        graph.addEdge("B", "K", 83);
        graph.addEdge("C", "I", 64);
        graph.addEdge("D", "N", 89);
        graph.addEdge("E", "J", 40);
        graph.addEdge("K", "H", 35);
        graph.addEdge("I", "L", 28);
        graph.addEdge("I", "M", 20);
        graph.addEdge("I", "F", 31);
        graph.addEdge("N", "F", 84);
        graph.addEdge("N", "J", 53);
        graph.addEdge("J", "G", 35);
        graph.addEdge("J", "Q", 80);
        graph.addEdge("H", "L", 36);
        graph.addEdge("L", "P", 63);
        graph.addEdge("M", "O", 50);
        graph.addEdge("G", "Q", 113);
        graph.addEdge("P", "O", 41);
        graph.addEdge("P", "R", 65);
        graph.addEdge("O", "R", 72);
        graph.addEdge("Q", "R", 65);

        // graph.addEdge("Arad", "Zerind", 75);
        // graph.addEdge("Arad", "Sibiu", 140);
        // graph.addEdge("Arad", "Timisoara", 118);
        // graph.addEdge("Zerind", "Oradea", 71);
        // graph.addEdge("Oradea", "Sibiu", 151);
        // graph.addEdge("Sibiu", "Fagaras", 99);
        // graph.addEdge("Sibiu", "Rimnicu Vilcea", 80);
        // graph.addEdge("Timisoara", "Lugoj", 111);
        // graph.addEdge("Lugoj", "Mehadia", 70);
        // graph.addEdge("Mehadia", "Drobeta", 75);
        // graph.addEdge("Drobeta", "Craiova", 120);
        // graph.addEdge("Craiova", "Rimnicu Vilcea", 146);
        // graph.addEdge("Craiova", "Pitesti", 138);
        // graph.addEdge("Rimnicu Vilcea", "Pitesti", 97);
        // graph.addEdge("Pitesti", "Bucharest", 101);
        // graph.addEdge("Bucharest", "Fagaras", 211);
        // graph.addEdge("Bucharest", "Giurgiu", 90);
        // graph.addEdge("Bucharest", "Urziceni", 85);
        // graph.addEdge("Urziceni", "Hirsova", 98);
        // graph.addEdge("Urziceni", "Vaslui", 142);
        // graph.addEdge("Hirsova", "Eforie", 86);
        // graph.addEdge("Vaslui", "Iasi", 92);
        // graph.addEdge("Iasi", "Neamt", 87);
    }

    public Graph getGraph() {
        return graph;
    }

    public int getHeuristic(String city) {
        return heuristics.get(city);
    }
}
