
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Graph graph = new Graph();
        GraphMatrix matrixGraph = new GraphMatrix();

        Scanner input = new Scanner(System.in);

        System.out.print("Enter file name: ");
        String filename = input.nextLine();

        Scanner scanner = new Scanner(new File(filename));

        while (scanner.hasNext()) {
            String vertex1 = scanner.next();
            String vertex2 = scanner.next();
            double weight = scanner.nextDouble();

            graph.addVertex(vertex1);
            graph.addVertex(vertex2);
            graph.addEdge(vertex1, vertex2, weight);

            matrixGraph.addVertex(vertex1);
            matrixGraph.addVertex(vertex2);
            matrixGraph.addEdge(vertex1, vertex2, weight);
        }

        scanner.close();

        System.out.println("Adjacency List BFS:");
        System.out.println(graph.breadthFirstTraversal("A"));

        System.out.println("Adjacency Matrix BFS:");
        System.out.println(matrixGraph.breadthFirstTraversal("A"));

        input.close();
    }
}
