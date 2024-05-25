import java.util.*;

@SuppressWarnings("hiding")
public class Search<Vertex> {
    // Set to keep track of the marked (visited) vertices
    protected Set<Vertex> marked;

    // Map to store the edge-to information for path reconstruction
    protected Map<Vertex, Vertex> edgeTo;

    // The source vertex for the search
    protected final Vertex source;

    // Constructor that takes the source vertex
    public Search(Vertex source) {
        this.source = source;
        marked = new HashSet<>();
        edgeTo = new HashMap<>();
    }

    // Method to check if a vertex has been visited
    public boolean hasPathTo(Vertex v) {
        return marked.contains(v);
    }

    // Method to reconstruct the path from the source to a given vertex
    public Iterable<Vertex> pathTo(Vertex v) {
        // If there is no path to the vertex, return null
        if (!hasPathTo(v)) return null;

        // Create a linked list to store the path
        LinkedList<Vertex> path = new LinkedList<>();

        // Start from the target vertex and traverse backwards using the edgeTo map
        Vertex current = v;
        while (current != source) {
            // Add the current vertex to the beginning of the path
            path.addFirst(current);
            // Move to the previous vertex in the path
            current = edgeTo.get(current);
        }

        // Add the source vertex to the beginning of the path
        path.addFirst(source);

        // Return the path
        return path;
    }
}