import java.util.*;

public class BreadthFirstSearch<V> extends Search<V> {
    private final Map<Vertex<V>, Vertex<V>> edgeTo = new HashMap<>();
    private final Set<Vertex<V>> visited = new HashSet<>();

    public BreadthFirstSearch(Vertex<V> start, Vertex<V> end) {
        super(start, end);
        bfs();
    }

    private void bfs() {
        Queue<Vertex<V>> queue = new LinkedList<>();
        visited.add(start);
        queue.add(start);

        while (!queue.isEmpty()) {
            Vertex<V> current = queue.poll();
            for (Vertex<V> neighbor : current.getAdjacentVertices().keySet()) {
                if (visited.add(neighbor)) {
                    edgeTo.put(neighbor, current);
                    queue.add(neighbor);
                }
            }
        }
    }

    @Override
    public List<Vertex<V>> getPath() {
        if (!visited.contains(end)) return Collections.emptyList();
        LinkedList<Vertex<V>> path = new LinkedList<>();
        for (Vertex<V> at = end; at != null && !at.equals(start); at = edgeTo.get(at)) {
            path.addFirst(at);
        }
        path.addFirst(start);
        return path;
    }
}
