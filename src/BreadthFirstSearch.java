import java.util.LinkedList;
import java.util.Queue;

@SuppressWarnings("hiding")
public class BreadthFirstSearch<Vertex> extends Search<Vertex> {
    // Constructor that initiates a Breadth-First Search from a source vertex in a given graph
    public BreadthFirstSearch(MyGraph<Vertex> graph, Vertex source) {
        super(source);

        // Start the Breadth-First Search algorithm from the source vertex
        bfs(graph, source);
    }

    // Method to perform Breadth-First Search traversal
    private void bfs(MyGraph<Vertex> graph, Vertex current) {
        // Mark the current vertex as visited
        marked.add(current);

        // Create a queue to store vertices for traversal
        Queue<Vertex> queue = new LinkedList<>();
        queue.add(current); // Add the source vertex to the queue

        // Continue traversal while the queue is not empty
        while (!queue.isEmpty()) {
            Vertex v = queue.remove(); // Dequeue the vertex for processing

            // Traverse through the adjacent vertices of the current vertex
            for (Vertex vertex : graph.adjacencyList(v)) {
                // If the adjacent vertex has not been visited
                if (!marked.contains(vertex)) {
                    // Mark the adjacent vertex as visited
                    marked.add(vertex);
                    // Update the edgeTo map to track the path
                    edgeTo.put(vertex, v);
                    // Enqueue the adjacent vertex for further traversal
                    queue.add(vertex);
                }
            }
        }
    }
}