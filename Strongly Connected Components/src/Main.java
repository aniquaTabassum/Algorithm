
import java.util.Scanner;
import java.util.Stack;
import java.util.Vector;

/*
 * @author Aniqua Tabassum
 */
public class Main {

    static Vector<Vector<Integer>> list;
    static Vector<Vector<Integer>> reversed;
    static boolean[] visited;
    static int[] color;
    static int white = 1;
    static int grey = 2;
    static int black = 3;
    static int nodes;
    static int edges;
    static int connectedComponents;
    static int count;
    static Stack<Integer> print;
    static Stack<Integer> stack;

    public static void dfs() {
        for (int i = 0; i < nodes; i++) {
            color[i] = white;
        }
        for (int i = 0; i < nodes; i++) {
            if (color[i] == white) {
                dfsVisit(i);
            }
        }
    }

    public static void dfsVisit(int s) {
        color[s] = grey;
        for (int i = 0; i < list.get(s).size(); i++) {
            if (color[list.get(s).get(i)] == white) {
                dfsVisit(list.get(s).get(i));
            }
        }
        color[s] = black;
        stack.push(s);
    }

    public static void dfsReversed() {
        //Marking all the nodes as unvisited
        for (int i = 0; i < nodes; i++) {
            color[i] = white;
        }
        print = new Stack<Integer>(); //A stack to store the elements of each connected component
        // Calling DFSReversed in the descending order of finishing time
        while (stack.empty() != true) {
            int node = stack.pop();
            if (color[node] == white) {         
                connectedComponents += 1;
                count = 1;
                dfsVisitReversed(node);
                // If there are no components strongly connected to the node from which DFSReversed was called
                // We decrement the value of connectedComponent
                if (count == 1) {
                    connectedComponents -= 1;
                } 
                //Else we print the strongly connected components
                else {
                    System.out.println("Strongly Connected Component number " + connectedComponents);
                    while (print.empty() != true) {
                        System.out.println(print.pop() + " ");
                    }
                }
            }
        }
    }

    public static void dfsVisitReversed(int s) {
        color[s] = grey;
        print.push(s);
        for (int i = 0; i < reversed.get(s).size(); i++) {
            if (color[reversed.get(s).get(i)] == white) {
                // If there are more nodes connected, we increment count
                count += 1;
                dfsVisitReversed(reversed.get(s).get(i));
            }
        }
        color[s] = black;
    }

    public static void main(String[] args) {
        System.out.println("Enter the number of nodes and edges: ");
        Scanner sc = new Scanner(System.in);
        nodes = sc.nextInt();
        edges = sc.nextInt();
        color = new int[nodes];
        connectedComponents = 0;
        list = new Vector<Vector<Integer>>(nodes);
        for (int i = 0; i < nodes; i++) {
            list.add(new Vector<Integer>());
        }
        reversed = new Vector<Vector<Integer>>(nodes);
        for (int i = 0; i < nodes; i++) {
            reversed.add(new Vector<Integer>());
        }
        stack = new Stack<Integer>();
        System.out.println("Enter the connections: ");
        for (int i = 0; i < edges; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            list.get(x).add(y); //creating the main adjacency vector
            reversed.get(y).add(x); //creating the reversed adjacency vector
        }
        dfs();
        dfsReversed();
        if (connectedComponents == 0) {
            System.out.println("There are no connected components");
        }
    }
}
