import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class WeightedGraph<V> {
    private final Set<Vertex<V>> vertices = new HashSet<>();
    private final boolean isDirected;

    public WeightedGraph(boolean isDirected) {
        this.isDirected = isDirected;
    }

    public void addVertex(Vertex<V> vertex) {
        if (vertex != null) vertices.add(vertex);
    }

    public void addEdge(Vertex<V> source, Vertex<V> destination, double weight) {
        Objects.requireNonNull(source);
        Objects.requireNonNull(destination);
        source.addAdjacentVertex(destination, weight);
        if (!isDirected) destination.addAdjacentVertex(source, weight);
        vertices.add(source);
        vertices.add(destination);
    }

    public Set<Vertex<V>> getVertices() {
        return Collections.unmodifiableSet(vertices);
    }
}
