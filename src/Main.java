public class Main {
    public static void main(String[] args) {
        Vertex<String> a = new Vertex<>("A");
        Vertex<String> b = new Vertex<>("B");
        Vertex<String> c = new Vertex<>("C");
        Vertex<String> d = new Vertex<>("D");

        WeightedGraph<String> graph = new WeightedGraph<>(false);
        graph.addEdge(a, b, 1);
        graph.addEdge(b, c, 3);
        graph.addEdge(a, d, 4);
        graph.addEdge(d, c, 1);

        Search<String> bfs = new BreadthFirstSearch<>(a, c);
        printPath("BFS", bfs.getPath());

        Search<String> dijkstra = new DijkstraSearch<>(a, c);
        printPath("Dijkstra", dijkstra.getPath());
    }

    private static void printPath(String name, java.util.List<Vertex<String>> path) {
        System.out.println(name + " Path: " + (path == null || path.isEmpty() ? "No path found." : String.join(" -> ", path.stream().map(Vertex::toString).toList())));
    }
}
