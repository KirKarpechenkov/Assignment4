import java.util.*;

@SuppressWarnings("hiding")
public class MyGraph<Vertex> {
    // Flag to determine if the graph is undirected
    private final boolean undirected;

    // Map to store vertices and their adjacent vertices
    private final Map<Vertex, List<Vertex>> map = new HashMap<>();

    // Default constructor creates an undirected graph
    public MyGraph() {
        this(true);
    }

    // Constructor to create a graph with specified directionality
    public MyGraph(boolean undirected) {
        this.undirected = undirected;
    }

    // Add a vertex to the graph
    public void addVertex(Vertex v) {
        // Check if the vertex already exists
        if (hasVertex(v))
            return;

        // Add a new entry to the map with an empty list for adjacent vertices
        map.put(v, new LinkedList<>());
    }

    // Add an edge between two vertices
    public void addEdge(Vertex source, Vertex dest) {
        // Check if the source vertex exists, if not, add it
        if (!hasVertex(source))
            addVertex(source);

        // Check if the destination vertex exists, if not, add it
        if (!hasVertex(dest))
            addVertex(dest);

        // Reject parallel edges and self-loops
        if (hasEdge(source, dest) || source.equals(dest))
            return;

        // Add the destination vertex to the source vertex's list of adjacent vertices
        map.get(source).add(dest);

        // If the graph is undirected, add the source vertex to the destination vertex's list
        if (undirected)
            map.get(dest).add(source);
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

    // Check if a vertex exists in the graph
    public boolean hasVertex(Vertex v) {
        return map.containsKey(v);
    }

    // Check if an edge exists between two vertices
    public boolean hasEdge(Vertex source, Vertex dest) {
        // If the source vertex doesn't exist, return false
        if (!hasVertex(source)) return false;
        // Check if the destination vertex is present in the source vertex's list of adjacent vertices
        return map.get(source).contains(dest);
    }

    // Get the adjacency list of a vertex
    public List<Vertex> adjacencyList(Vertex v) {
        // If the vertex doesn't exist, return null
        if (!hasVertex(v)) return null;
        // Return the list of adjacent vertices for the given vertex
        return map.get(v);
    }
}