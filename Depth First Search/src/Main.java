
import java.util.Scanner;
import java.util.Stack;
import java.util.Vector;

/*
 * @author Aniqua Tabassum
 */
public class Main {

    static Vector<Vector<Integer>> list;
    static boolean[] visited;
    static int[] color;
    static int[] parent;
    static int[] discover;
    static int[] finish;
    static int white = 1;
    static int grey = 2;
    static int black = 3;
    static int time;
    static int nodes;
    static int edges;
    public static void dfs() {
        for (int i = 0; i < nodes; i++) {
            color[i] = white;
            parent[i] = Integer.MIN_VALUE;
        }
        time = 0;
        for (int i = 0; i < nodes; i++) {
            if (color[i] == white) {
                dfsVisit(i);
            }
        }
    }

    public static void dfsVisit(int s) {
        time += 1;
        System.out.println(s);
        color[s] = grey;
        discover[s] = time;
        for (int i = 0; i < list.get(s).size(); i++) {
            if (color[list.get(s).get(i)] == white) {
                parent[i] = s;
                dfsVisit(list.get(s).get(i));
            }
        }
        color[s] = black;
        time += 1;
        finish[s] = time;
        
    }

    public static void main(String[] args) {
        System.out.println("Enter the number of nodes and edges: ");
        Scanner sc = new Scanner(System.in);
        nodes = sc.nextInt();
        edges = sc.nextInt();
        visited = new boolean[nodes];
        color = new int[nodes];
        parent = new int[nodes];
        discover = new int[nodes];
        finish = new int[nodes];
        list = new Vector<Vector<Integer>>(nodes);
        for (int i = 0; i < nodes; i++) {
            list.add(new Vector<Integer>());
        }
        System.out.println("Enter the connections: ");
        for (int i = 0; i < edges; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            list.get(x).add(y);
            list.get(y).add(x);
        }
        dfs();
        
    }
}
