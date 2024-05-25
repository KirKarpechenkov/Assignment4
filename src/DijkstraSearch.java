import java.util.*;

@SuppressWarnings("hiding")
public class DijkstraSearch<Vertex> extends Search<Vertex> {
    // Set to store unsettled nodes (vertices that have not been processed yet)
    private final Set<Vertex> unsettledNodes;

    // Map to store the distances from the source to each vertex
    private final Map<Vertex, Double> distances;

    // Reference to the weighted graph
    private final WeightedGraph<Vertex> graph;

    // Constructor that takes the graph and source vertex
    public DijkstraSearch(WeightedGraph<Vertex> graph, Vertex source) {
        super(source);
        unsettledNodes = new HashSet<>();
        distances = new HashMap<>();
        this.graph = graph;

        // Start the Dijkstra algorithm
        dijkstra();
    }

    // Implementation of Dijkstra's algorithm
    public void dijkstra() {
        // Set the distance from the source to itself as 0
        distances.put(source, 0D);
        // Add the source vertex to the unsettled nodes set
        unsettledNodes.add(source);

        // Continue until all nodes are settled
        while (!unsettledNodes.isEmpty()) {
            // Get the vertex with the minimum distance from the unsettled nodes
            Vertex currentNode = getVertexWithMinimumWeight(unsettledNodes);

            // Mark the current node as settled
            marked.add(currentNode);
            // Remove the current node from the unsettled nodes set
            unsettledNodes.remove(currentNode);

            // Process the neighbors of the current node
            for (Vertex neighbor : graph.adjacencyList(currentNode)) {
                // Calculate the new distance to the neighbor
                double newDistance = getShortestDistance(currentNode) + graph.getWeight(currentNode, neighbor);

                // If the new distance is shorter than the current distance, update the distance and edge
                if (getShortestDistance(neighbor) > newDistance) {
                    distances.put(neighbor, newDistance);
                    edgeTo.put(neighbor, currentNode);
                    unsettledNodes.add(neighbor);
                }
            }
        }
    }

    // Helper method to find the vertex with the minimum distance from the given set of vertices
    private Vertex getVertexWithMinimumWeight(Set<Vertex> vertices) {
        Vertex minimum = null;
        for (Vertex vertex : vertices) {
            if (minimum == null || getShortestDistance(vertex) < getShortestDistance(minimum)) {
                minimum = vertex;
            }
        }
        return minimum;
    }

    // Helper method to get the shortest distance to a vertex
    private double getShortestDistance(Vertex neighbor) {
        Double d = distances.get(neighbor);
        return (d == null ? Double.MAX_VALUE : d);
    }
}