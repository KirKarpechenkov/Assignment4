@SuppressWarnings("hiding")
public class DepthFirstSearch<Vertex> extends Search<Vertex> {
    // Constructor that initiates a Depth-First Search from a source vertex in a given graph
    public DepthFirstSearch(MyGraph<Vertex> graph, Vertex source) {
        super(source);

        // Start the Depth-First Search algorithm from the source vertex
        dfs(graph, source);
    }

    // Recursive method to perform Depth-First Search traversal
    private void dfs(MyGraph<Vertex> graph, Vertex current) {
        // Mark the current vertex as visited
        marked.add(current);

        // Traverse through the adjacent vertices of the current vertex
        for (Vertex v : graph.adjacencyList(current)) {
            // If the adjacent vertex has not been visited
            if (!marked.contains(v)) {
                // Update the edgeTo map to track the path
                edgeTo.put(v, current);
                // Recursively visit the adjacent vertex
                dfs(graph, v);
            }
        }
    }
}