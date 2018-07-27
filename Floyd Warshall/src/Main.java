
import java.util.Scanner;
import java.util.Vector;

/**
 *
 * @author Aniqua Tabassum
 */
public class Main {

    static Vector<Vector<Integer>> graph;
    static int nodes;
    static int edges;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        nodes = sc.nextInt();
        edges = sc.nextInt();
        graph = new Vector<Vector<Integer>>();
        for (int i = 0; i < nodes; i++) {
            graph.add(new Vector<Integer>());
        }
        for (int i = 0; i <nodes; i++) {
            for (int j = 0; j <nodes; j++) {
                if (i == j) {
                    graph.get(i).add(0);
                } else {
                    graph.get(i).add(99999);
                }
            }
        }
        for (int i = 0; i < edges; i++) {

            graph.get(sc.nextInt()).set(sc.nextInt(), sc.nextInt());
        }
        for (int k = 0; k < nodes; k++) {
            for (int i = 0; i < nodes; i++) {

                for (int j = 0; j < nodes; j++) {

                    if (i != j) {
                        graph.get(i).set(j, Math.min(graph.get(i).get(j), graph.get(i).get(k) + graph.get(k).get(j)));
                    }
                }
            }
        }
        for (int i = 0; i < nodes; i++) {
            for (int j = 0; j < nodes; j++) {
                System.out.print(i + " " + j + " ");
                if (graph.get(i).get(j) == 99999) {
                    System.out.println("Infinity");
                } else {
                    System.out.println(graph.get(i).get(j));
                }

            }
        }
    }

}
