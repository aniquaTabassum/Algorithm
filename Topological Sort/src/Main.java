
import java.util.Scanner;
import java.util.Stack;
import java.util.Vector;

/*
 * @author Aniqua Tabassum
 */
public class Main {

    static Vector<Vector<Integer>> list;
    static int[] color;
    static int[] discover;
    static int[] finish;
    static int white = 1;
    static int grey = 2;
    static int black = 3;
    static int time;
    static int nodes;
    static int edges;
    static Stack<Integer> stack;

    public static void dfs() {
        for (int i = 0; i < nodes; i++) {
            color[i] = white;
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
        color[s] = grey;
        discover[s] = time;
        for (int i = 0; i < list.get(s).size(); i++) {
            if (color[list.get(s).get(i)] == white) {

                dfsVisit(list.get(s).get(i));
            }
        }
        color[s] = black;
        time += 1;
        finish[s] = time;
        stack.push(s);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        nodes = sc.nextInt();
        edges = sc.nextInt();
        color = new int[nodes];
        discover = new int[nodes];
        finish = new int[nodes];
        stack = new Stack<Integer>();
        list = new Vector<Vector<Integer>>(nodes);
        for (int i = 0; i < nodes; i++) {
            list.add(new Vector<Integer>());
        }

        for (int i = 0; i < edges; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            list.get(x).add(y);

        }
        dfs();
        for (int i = 0; i < nodes; i++) {
            System.out.print(stack.pop() + " ");
        }

    }
}
