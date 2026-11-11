
import java.util.*;

public class Graph {
    private Map<Vertex, List<Edge>> adjVertices;

    public Graph() {
        adjVertices = new LinkedHashMap<>();
    }

    public void addVertex(String label) {
        adjVertices.putIfAbsent(new Vertex(label), new ArrayList<>());
    }

    public void removeVertex(String label) {
        Vertex v = new Vertex(label);

        adjVertices.values().forEach(edges ->
                edges.removeIf(edge -> edge.destination.equals(v))
        );

        adjVertices.remove(v);
    }

    public void addEdge(String label1, String label2, double weight) {
        Vertex v1 = new Vertex(label1);
        Vertex v2 = new Vertex(label2);

        adjVertices.get(v1).add(new Edge(v2, weight));
        adjVertices.get(v2).add(new Edge(v1, weight));
    }

    public void removeEdge(String label1, String label2) {
        Vertex v1 = new Vertex(label1);
        Vertex v2 = new Vertex(label2);

        List<Edge> eV1 = adjVertices.get(v1);
        List<Edge> eV2 = adjVertices.get(v2);

        if (eV1 != null)
            eV1.removeIf(edge -> edge.destination.equals(v2));

        if (eV2 != null)
            eV2.removeIf(edge -> edge.destination.equals(v1));
    }

    public Set<String> breadthFirstTraversal(String root) {
        Set<String> visited = new LinkedHashSet<>();
        Queue<String> queue = new LinkedList<>();

        if (getAdjVertices(root) == null)
            return visited;

        queue.add(root);
        visited.add(root);

        while (!queue.isEmpty()) {
            String vertex = queue.poll();

            for (Edge e : getAdjVertices(vertex)) {
                Vertex v = e.destination;

                if (!visited.contains(v.label)) {
                    visited.add(v.label);
                    queue.add(v.label);
                }
            }
        }

        return visited;
    }

    public List<Edge> getAdjVertices(String label) {
        return adjVertices.get(new Vertex(label));
    }
}
