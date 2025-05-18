import java.util.*;

public class DijkstraSearch<V> extends Search<V> {
    private final Map<Vertex<V>, Double> distances = new HashMap<>();
    private final Map<Vertex<V>, Vertex<V>> previous = new HashMap<>();

    public DijkstraSearch(Vertex<V> start, Vertex<V> end) {
        super(start, end);
        dijkstra();
    }

    private void dijkstra() {
        Set<Vertex<V>> visited = new HashSet<>();
        distances.put(start, 0.0);
        PriorityQueue<Vertex<V>> pq = new PriorityQueue<>(Comparator.comparingDouble(distances::get));
        pq.add(start);

        while (!pq.isEmpty()) {
            Vertex<V> current = pq.poll();
            if (!visited.add(current)) continue;

            for (Map.Entry<Vertex<V>, Double> entry : current.getAdjacentVertices().entrySet()) {
                Vertex<V> neighbor = entry.getKey();
                double weight = entry.getValue();
                double newDist = distances.getOrDefault(current, Double.POSITIVE_INFINITY) + weight;

                if (newDist < distances.getOrDefault(neighbor, Double.POSITIVE_INFINITY)) {
                    distances.put(neighbor, newDist);
                    previous.put(neighbor, current);
                    pq.add(neighbor);
                }
            }
        }
    }

    @Override
    public List<Vertex<V>> getPath() {
        LinkedList<Vertex<V>> path = new LinkedList<>();
        Vertex<V> current = end;
        while (current != null && previous.containsKey(current) || current.equals(start)) {
            path.addFirst(current);
            current = previous.get(current);
        }
        return path.isEmpty() || !path.getFirst().equals(start) ? Collections.emptyList() : path;
    }
}
