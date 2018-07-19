
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class DijkstrawithAdjacencyList {

    static int V;
    static Graph graph;
    static int[] parent;
    static Node[] keys;
    static AdjList adjList;
    static boolean[] visited;

    public static class Node implements Comparable<Node> {

        int vertice;
        int key;

        Node(int vertice, int key) {
            this.vertice = vertice;
            this.key = key;
        }

        @Override
        public int compareTo(Node o) {
            return this.key - o.key;
        }
    }

    public static class AdjList {

        ArrayList<Node> nodes;
    }

    public static class Graph {

        int V;
        AdjList[] adjLists;
    }

    public static Graph createGraph() {
        graph.adjLists = new AdjList[V];
        for (int i = 0; i < V; i++) {
            adjList = new AdjList();
            adjList.nodes = new ArrayList<Node>();
            graph.adjLists[i] = adjList;
        }
        return graph;
    }

    public static void addEdge(int src, int dest, int key) {
        Node srcNode = new Node(src, key);
        Node destNode = new Node(dest, key);
        graph.adjLists[src].nodes.add(destNode);
        graph.adjLists[dest].nodes.add(srcNode);
    }

    public static void getDijkstra() {
        keys = new Node[V];
        parent = new int[V];
        visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            keys[i] = new Node(i, Integer.MAX_VALUE);
            parent[i] = -1;
            visited[i] = false;
        }

        keys[0].key = 0;
        Queue<Node> pQueue = new PriorityQueue<>();
        pQueue.addAll(Arrays.asList(keys));

        while (pQueue.size() > 1) {
            Node u = pQueue.remove();
            visited[u.vertice] = true;

            for (Node node : graph.adjLists[u.vertice].nodes) {

                if (visited[node.vertice] == false && (node.key + u.key) < keys[node.vertice].key) {
                    pQueue.remove(keys[node.vertice]);
                    keys[node.vertice].key = node.key + u.key;
                    parent[node.vertice] = u.vertice;
                    pQueue.add(keys[node.vertice]);
                }
            }
        }
        
    }

    static int index;
    static int[] path;

    public static void printPath(int n) {

        if(parent[n] == -1)
        {
            for(int i=index-1;i>=0;i--)
            {
                int x = path[i];
                System.out.print((x+1)+" ");
            }
            index = 0;
            path = new int[V];
            return;
        }
        else{
            path[index] = parent[n];
            //System.out.println("parent is "+(path[index]+1));
            index+=1;
            printPath(parent[n]);
            
            
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        V = sc.nextInt();
        int edges = sc.nextInt();
        index = 0;
        path = new int[V];
        graph = new Graph();
        createGraph();
        for (int i = 0; i < edges; i++) {
            int source = sc.nextInt();
            int destination = sc.nextInt();
            int weight = sc.nextInt();
            addEdge((source - 1), (destination - 1), weight);
        }

        getDijkstra();

        for(int i=0;i<V;i++)
        {   
            System.out.print((i + 1) + " " + keys[i].key+" ");
            printPath(i);
            //if(i!=0)
            System.out.print((i+1)+" ");
            System.out.println("");
        }
    }
}
