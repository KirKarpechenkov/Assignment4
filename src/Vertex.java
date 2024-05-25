import java.util.*;

public class Vertex<V> {
    // The value or data associated with the vertex
    private V value;

    // A map to store the adjacent vertices and their weights
    private Map<Vertex<V>, Double> adjacementVertices;

    // Constructor that takes the value of the vertex
    public Vertex(V value) {
        this.value = value;
        adjacementVertices = new HashMap<>();
    }

    // Getter method to retrieve the value of the vertex
    public V getValue() {
        return value;
    }

    // Getter method to retrieve the map of adjacent vertices and their weights
    public Map<Vertex<V>, Double> getAdjacementVertices() {
        return adjacementVertices;
    }

    // Method to add an adjacent vertex and its weight
    public void addAdjacementVertex(Vertex<V> vertex, double weight) {
        adjacementVertices.put(vertex, weight);
    }

    // Overridden equals method to compare vertices based on their values
    @Override
    public boolean equals(Object o) {
        // Check if the objects are the same reference
        if (this == o) return true;

        // Check if the object is null or of a different class
        if (o == null || getClass() != o.getClass()) return false;

        // Cast the object to a Vertex
        Vertex<?> otherVertex = (Vertex<?>) o;

        // Compare the values of the vertices
        return Objects.equals(this.value, otherVertex.value);
    }
}
