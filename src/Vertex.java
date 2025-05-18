import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Vertex<V> {
    private final V data;
    private final Map<Vertex<V>, Double> adjacentVertices = new HashMap<>();

    public Vertex(V data) {
        if (data == null) throw new IllegalArgumentException("Vertex data cannot be null.");
        this.data = data;
    }

    public V getData() {
        return data;
    }

    public void addAdjacentVertex(Vertex<V> destination, double weight) {
        if (destination == null) throw new IllegalArgumentException("Destination vertex cannot be null.");
        if (weight < 0) throw new IllegalArgumentException("Edge weight cannot be negative.");
        adjacentVertices.put(destination, weight);
    }

    public Map<Vertex<V>, Double> getAdjacentVertices() {
        return Collections.unmodifiableMap(adjacentVertices);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Vertex<?> other)) return false;
        return Objects.equals(data, other.data);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(data);
    }

    @Override
    public String toString() {
        return "Vertex{" + "data=" + data + '}';
    }
}
