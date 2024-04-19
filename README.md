<div>
    <h2>
        ♨️  Implementação dos Métodos de Buscas
    </h2>
    <h6>
        Trabalho apresentado como requisito para conclusão da disciplina de Inteligência Artificial, do curso de Análise e Desenvolvimento de Sistemas (2024.1), do Instituto Federal do Piauí - Campus Picos.
    </h6>
</div>

##

<div>
    <h3>
        Como funciona?
    </h3>
    <h5>
        O programa recebe um problema utilizando as classes "Graph", "Edge", "Node" e "PriorityNode" dentro de uma classe, como por exemplo:
    </h5>
</div>

```
  public class RomeniaMap {
      private final Graph graph = new Graph();
      private final Map<String, Integer> heuristics = new HashMap<>();
  
      public RomeniaMap() {
          initializeHeuristics();
          initializeGraph();
      }
  
      private void initializeHeuristics() {
          heuristics.put("Arad", 366);
          heuristics.put("Bucharest", 0);
          heuristics.put("Craiova", 160);
          [...]
      }
  
      private void initializeGraph() {
          for (Map.Entry<String, Integer> entry : heuristics.entrySet()) {
              graph.addNode(entry.getKey(), entry.getValue());
          }
  
          graph.addEdge("Arad", "Zerind", 75);
          graph.addEdge("Arad", "Sibiu", 140);
          graph.addEdge("Arad", "Timisoara", 118);
          [...]
      }
  
      public Graph getGraph() {
          return graph;
      }
  
      public int getHeuristic(String city) {
          return heuristics.get(city);
      }
  }

```

<div>
    <h5>
      E, assim, um grafo é criado com os valores de suas arestas e heurísticas, podendo aplicar métodos de busca de um estado inicial até um estado final e fazer com que o programa informe na saída o caminho do início até o objetivo.
    </h5>
    <h5>
      O arquivo Main.java (que inicializa o programa) tem o seguinte:
    </h5>
</div>

```
  System.out.println("-> Buscas não informadas <-\n");

  List<String> pathBFS = BreadthFirst.breadthFirstSearch(graph, "Arad", "Bucharest");
  System.out.println("Caminho de Arad até Bucharest usando Busca em Largura:\n" + pathBFS);
  [...se repete para cada método de busca]
```

<div>
  <h5>
    Mostrando a seguinte saída:
  </h5>
</div>

```
  -> Buscas não informadas <-

  Caminho de Arad até Bucharest usando Busca em Largura:
  [Arad, Sibiu, Fagaras, Bucharest]
  
  [...]
  
  -> Buscas informadas <-
  
  Caminho de Arad até Bucharest usando A*:
  [Arad, Sibiu, Rimnicu Vilcea, Pitesti, Bucharest]
  
  Caminho de Arad até Bucharest usando Busca Gulosa:
  [Arad, Sibiu, Fagaras, Bucharest]
```

##
