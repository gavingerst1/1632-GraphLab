
import java.util.*;

public class GraphMatrix {
    private List<String> vertices;
    private double[][] matrix;

    public GraphMatrix() {
        vertices = new ArrayList<>();
        matrix = new double[0][0];
    }

    public void addVertex(String label) {
        if (vertices.contains(label))
            return;

        vertices.add(label);

        int size = vertices.size();
        double[][] newMatrix = new double[size][size];

        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - 1; j++) {
                newMatrix[i][j] = matrix[i][j];
            }
        }

        matrix = newMatrix;
    }

    public void addEdge(String label1, String label2, double weight) {
        int i = vertices.indexOf(label1);
        int j = vertices.indexOf(label2);

        if (i == -1 || j == -1)
            return;

        matrix[i][j] = weight;
        matrix[j][i] = weight;
    }

    public Set<String> breadthFirstTraversal(String root) {
        Set<String> visited = new LinkedHashSet<>();
        Queue<String> queue = new LinkedList<>();

        if (!vertices.contains(root))
            return visited;

        queue.add(root);
        visited.add(root);

        while (!queue.isEmpty()) {
            String vertex = queue.poll();
            int index = vertices.indexOf(vertex);

            for (int i = 0; i < vertices.size(); i++) {
                if (matrix[index][i] != 0) {
                    String neighbor = vertices.get(i);

                    if (!visited.contains(neighbor)) {
                        visited.add(neighbor);
                        queue.add(neighbor);
                    }
                }
            }
        }

        return visited;
    }
}
