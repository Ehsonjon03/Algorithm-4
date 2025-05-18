import java.util.Objects;

public class Edge<T> {
    private final Vertex<T> source;
    private final Vertex<T> destination;
    private final double weight;

    public Edge(Vertex<T> source, Vertex<T> destination) {
        this(source, destination, 0);
    }

    public Edge(Vertex<T> source, Vertex<T> destination, double weight) {
        if (source == null || destination == null) throw new IllegalArgumentException("Vertices cannot be null");
        if (weight < 0) throw new IllegalArgumentException("Weight cannot be negative");
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    public Vertex<T> getSource() {
        return source;
    }

    public Vertex<T> getDestination() {
        return destination;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return source + " -> " + destination + " (weight: " + weight + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Edge<?> e)) return false;
        return Double.compare(e.weight, weight) == 0 &&
                Objects.equals(source, e.source) &&
                Objects.equals(destination, e.destination);
    }

    @Override
    public int hashCode() {
        return Objects.hash(source, destination, weight);
    }
}
