import java.util.*;

public class Vertex<V> {
    private V value;
    private Map<Vertex<V>, Double> adjacementVertices;

    public Vertex(V value) {
        this.value = value;
        adjacementVertices = new HashMap<>();
    }

    public V getValue() {
        return value;
    }

    public Map<Vertex<V>, Double> getAdjacementVertices() {
        return adjacementVertices;
    }

    public void addAdjacementVertex(Vertex<V> vertex, double weight) {
        adjacementVertices.put(vertex, weight);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Vertex<?> otherVertex = (Vertex<?>) o;

        return Objects.equals(this.value, otherVertex.value);
    }
}
