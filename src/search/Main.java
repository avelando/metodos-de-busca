package search;

import search.methods.*;
import search.nodes.Graph;
import search.problem.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        RomeniaMap romeniaMap = new RomeniaMap();
        Graph graph = romeniaMap.getGraph();

        int depthLimit = 6;

        System.out.println("-> Buscas não informadas <-\n");

        List<String> pathBFS = BreadthFirst.breadthFirstSearch(graph, "Arad", "Bucharest");
        System.out.println("Caminho de Arad até Bucharest usando Busca em Largura:\n" + pathBFS);

        List<String> pathDFS = DepthFirst.depthFirstSearch(graph, "Arad", "Bucharest");
        System.out.println("\nCaminho de Arad até Bucharest usando Busca em Profundidade:\n" + pathDFS);

        List<String> pathDL = DepthLimited.depthLimitedSearch(graph, "Arad", "Bucharest", depthLimit);
        System.out.println("\nCaminho de Arad até Bucharest usando Busca em Profundidade Limitada:\n" + pathDL);

        List<String> pathUC = UniformCost.uniformCostSearch(graph, "Arad", "Bucharest");
        System.out.println("\nCaminho de Arad até Bucharest usando Busca em Custo Uniforme:\n" + pathUC);

        List<String> pathID = IterativeDeepening.iterativeDeepeningSearch(graph, "Arad", "Bucharest");
        System.out.println("\nCaminho de Arad até Bucharest usando Busca em Profundidade Iterativa:\n" + pathID);

        System.out.println("\n-> Buscas informadas <-\n");

        List<String> pathAStar = AStar.aStarSearch(graph, "Arad", "Bucharest");
        System.out.println("Caminho de Arad até Bucharest usando A*:\n" + pathAStar);

        List<String> pathGreedy = Greedy.greedySearch(graph, "Arad", "Bucharest");
        System.out.println("\nCaminho de Arad até Bucharest usando Busca Gulosa:\n" + pathGreedy);
    }
}
