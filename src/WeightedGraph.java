import java.util.*;

@SuppressWarnings("hiding")
public class WeightedGraph<Vertex> {
    // Flag to determine if the graph is undirected
    private final boolean undirected;

    // Map to store the vertices and their adjacent vertices with weights
    private final Map<Vertex, Map<Vertex, Double>> map = new HashMap<>();

    // Default constructor creates an undirected graph
    public WeightedGraph() {
        this(true);
    }

    // Constructor to create a graph with specified directionality
    public WeightedGraph(boolean undirected) {
        this.undirected = undirected;
    }

    // Add a vertex to the graph
    public void addVertex(Vertex v) {
        // Check if the vertex already exists
        if (hasVertex(v))
            return;

        // Add a new entry to the map with an empty inner map for adjacent vertices
        map.put(v, new HashMap<>());
    }

    // Get the number of vertices in the graph
    public int getVerticesCount() {
        return map.size();
    }

    // Get the number of edges in the graph
    public int getEdgesCount() {
        int count = 0;
        // Iterate through the vertices and count the number of adjacent vertices
        for (Vertex v : map.keySet()) {
            count += map.get(v).size();
        }

        // If the graph is undirected, divide the count by 2 to avoid double counting
        if (undirected)
            count /= 2;

        return count;
    }

    // Add an edge between two vertices with a specified weight
    public void addEdge(Vertex source, Vertex dest, double weight) {
        // Check if the source vertex exists, if not, add it
        if (!hasVertex(source))
            addVertex(source);

        // Check if the destination vertex exists, if not, add it
        if (!hasVertex(dest))
            addVertex(dest);

        // Add the destination vertex and its weight to the source vertex's inner map
        map.get(source).put(dest, weight);

        // If the graph is undirected, add the source vertex and its weight to the destination vertex's inner map
        if (undirected)
            map.get(dest).put(source, weight);
    }

    // Check if a vertex exists in the graph
    public boolean hasVertex(Vertex v) {
        return map.containsKey(v);
    }

    // Check if an edge exists between two vertices
    public boolean hasEdge(Vertex source, Vertex dest) {
        // If the source vertex doesn't exist, return false
        if (!hasVertex(source)) return false;
        // Check if the destination vertex is present in the source vertex's inner map
        return map.get(source).containsKey(dest);
    }

    // Get the adjacency list of a vertex
    public List<Vertex> adjacencyList(Vertex v) {
        // If the vertex doesn't exist, return null
        if (!hasVertex(v)) return null;
        // Create a new list and add the keys (adjacent vertices) from the vertex's inner map
        return new ArrayList<>(map.get(v).keySet());
    }

    // Get the edges of a vertex
    public Iterable<Vertex> getEdges(Vertex v) {
        // If the vertex doesn't exist, return null
        if (!hasVertex(v)) return null;
        // Return the keys (adjacent vertices) from the vertex's inner map
        return map.get(v).keySet();
    }

    // Get the weight of an edge between two vertices
    public double getWeight(Vertex source, Vertex dest) {
        // If the source vertex doesn't exist or the destination vertex is not adjacent to the source, return -1
        if (!hasVertex(source) || !map.get(source).containsKey(dest)) {
            return -1;
        }
        // Return the weight of the edge between the source and destination vertices
        return map.get(source).get(dest);
    }
}