import java.util.List;

public abstract class Search<V> {
    protected Vertex<V> start;
    protected Vertex<V> end;

    public Search(Vertex<V> start, Vertex<V> end) {
        this.start = start;
        this.end = end;
    }

    public abstract List<Vertex<V>> getPath();
}