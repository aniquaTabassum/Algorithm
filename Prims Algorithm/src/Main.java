
import java.util.*;
import java.lang.*;
import java.io.*;

class MST {

    private static int V;
    static int edges;

    int minKey(int key[], Boolean mstSet[]) {

        int min = Integer.MAX_VALUE, min_index = -1;

        for (int v = 0; v < V; v++) {
            if (mstSet[v] == false && key[v] < min) {
                min = key[v];
                min_index = v;
            }
        }

        return min_index;
    }

    void printMST(int parent[], int n, int graph[][]) {
        System.out.println("Edge   Weight");
        for (int i = 1; i < V; i++) {
            System.out.println(parent[i] + " - " + i + "    "
                    + graph[i][parent[i]]);
        }
    }

    void primMST(int graph[][]) {
        int parent[] = new int[V];

        int key[] = new int[V];

        Boolean mstSet[] = new Boolean[V];

        for (int i = 0; i < V; i++) {
            key[i] = Integer.MAX_VALUE;
            mstSet[i] = false;
        }

        key[0] = 0;
        parent[0] = -1;

        for (int count = 0; count < V - 1; count++) {
            int u = minKey(key, mstSet);

            mstSet[u] = true;
            for (int v = 0; v < V; v++) {
                if (graph[u][v] != 0 && mstSet[v] == false
                        && graph[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = graph[u][v];
                }
            }
        }
        printMST(parent, V, graph);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        MST t = new MST();
        V = sc.nextInt();
        edges = sc.nextInt();
        int graph[][] = new int[V][V];

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                int weight = sc.nextInt();
                graph[i][j] = weight;
                graph[j][i] = weight;
            }
        }
        t.primMST(graph);
    }
}
