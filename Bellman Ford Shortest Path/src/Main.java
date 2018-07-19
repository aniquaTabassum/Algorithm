
import java.util.*;
class Main {

    static Vector<Edge> edge;
    static int[] dist;
    static int V;
    static int E;

    public static class Edge {

        int src;
        int dest;
        int weight;

        public Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }

    static void bellmanFord(int src) {

        dist = new int[V];
        for (int i = 0; i < V; ++i) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[src] = 0;

        for (int i = 1; i < V; ++i) {
            for (int j = 0; j < E; ++j) {
                int u = edge.get(j).src;
                int v = edge.get(j).dest;
                int weight = edge.get(j).weight;
                if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                }
            }
        }

        for (int j = 0; j < E; ++j) {
            int u = edge.get(j).src;
            int v = edge.get(j).dest;
            int weight = edge.get(j).weight;
            if (dist[u] != Integer.MAX_VALUE
                    && dist[u] + weight < dist[v]) {
                System.out.println("Graph contains negative weight cycle");
            }
        }
        printArr();
    }

    static void printArr() {
        System.out.println("Vertex   Distance from Source");
        for (int i = 0; i < V; ++i) {
            System.out.println(i + "          " + dist[i]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        V = sc.nextInt();  // Number of vertices in graph
        E = sc.nextInt();  // Number of edges in graph

        edge = new Vector<Edge>();

        for (int i = 0; i < E; i++) {
            edge.add(new Edge(sc.nextInt(), sc.nextInt(), sc.nextInt()));
        }

        bellmanFord(0);
    }
}
