public class Main {
    public static void main(String[] args) {
        // Create a weighted graph and fill it with edges and weights
        WeightedGraph<String> weightedGraph = new WeightedGraph<>(true);
        fillWithWeights(weightedGraph);

        // Perform Dijkstra's algorithm on the weighted graph
        System.out.println("Dijkstra:");
        Search<String> djk = new DijkstraSearch<>(weightedGraph, "Almaty");
        outputPath(djk, "Kyzylorda");

        // Print a separator
        System.out.println("--------------------------------");

        // Create an unweighted graph and fill it with edges
        MyGraph<String> graph = new MyGraph<>(true);
        fillWithoutWeights(graph);

        // Perform depth-first search on the unweighted graph
        System.out.println("DFS:");
        Search<String> dfs = new DepthFirstSearch<>(graph, "Almaty");
        outputPath(dfs, "Kyzylorda");

        // Print a separator
        System.out.println("--------------------------------");

        // Perform breadth-first search on the unweighted graph
        System.out.println("BFS:");
        Search<String> bfs = new BreadthFirstSearch<>(graph, "Almaty");
        outputPath(bfs, "Kyzylorda");
    }

    // Helper method to fill the unweighted graph with edges
    public static void fillWithoutWeights(MyGraph<String> graph) {
        graph.addEdge("Almaty", "Astana"); // 16 - 19
        graph.addEdge("Shymkent", "Atyrau");
        graph.addEdge("Atyrau", "Astana");
        graph.addEdge("Almaty", "Shymkent");
        graph.addEdge("Shymkent", "Astana");
        graph.addEdge("Astana", "Kostanay");
        graph.addEdge("Shymkent", "Kyzylorda");
    }

    // Helper method to fill the weighted graph with edges and weights
    public static void fillWithWeights(WeightedGraph<String> graph) {
        graph.addEdge("Almaty", "Astana", 2.1);
        graph.addEdge("Shymkent", "Atyrau", 7.8);
        graph.addEdge("Atyrau", "Astana", 7.1);
        graph.addEdge("Almaty", "Shymkent", 7.2);
        graph.addEdge("Shymkent", "Astana", 3.9);
        graph.addEdge("Astana", "Kostanay", 3.5);
        graph.addEdge("Shymkent", "Kyzylorda", 5.4);
    }

    // Helper method to output the path from the source to the target vertex
    public static void outputPath(Search<String> search, String key) {
        for (String v : search.pathTo(key)) {
            System.out.print(v + " -> ");
        }
        System.out.println();
    }
}