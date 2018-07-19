
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {

    static int[] parent;
    static int nodes;
    static int edges;
    static List<Pairs> edgesAndWeight;
    public static void initialise() {
        for (int i = 0; i < edges; i++) {
            parent[i] = i;
        }
    }

    public static int root(int x) {
        while (parent[x] != x) {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }

    public static void union1(int x, int y) {
        int p = root(x);
        int q = root(y);
        parent[p] = parent[q];
    }

    public static void kruskal() {
        int x, y;
       
        for (int i = 0; i < edges; ++i) {
            x = edgesAndWeight.get(i).getX();
            y = edgesAndWeight.get(i).getY();
           
            if (root(x) != root(y)) {
               
                union1(x, y);
                System.out.print((x+1)+" "+(y+1)+" "+edgesAndWeight.get(i).getWeight());
               
            } 
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of nodes and edges");
        nodes = sc.nextInt();
        edges = sc.nextInt();
        edgesAndWeight = new ArrayList<Pairs>();
        parent = new int[edges];
        System.out.println("Enter x y and weight");
        for (int i = 0; i < edges; i++) {

            int x = sc.nextInt();
            int y = sc.nextInt();
            int weight = sc.nextInt();
            x -= 1;
            y -= 1;
            Pairs pair = new Pairs(weight, x, y);
            edgesAndWeight.add(pair);
        }
        System.out.println("");
        Collections.sort(edgesAndWeight, Pairs.weightComparator);
        initialise();
        kruskal();
        
    }

    static class Pairs {

        int weight;
        int x;
        int y;

        public Pairs(int weight, int x, int y) {
            this.weight = weight;
            this.x = x;
            this.y = y;
        }

        public int getWeight() {
            return this.weight;
        }

        public int getX() {
            return this.x;
        }

        public int getY() {
            return this.y;
        }
        public static Comparator<Pairs> weightComparator = new Comparator<Pairs>() {

            public int compare(Pairs p1, Pairs p2) {
                int weight1 = p1.getWeight();
                int weight2 = p2.getWeight();
                return weight2 - weight1;

            }
        };
    }
}
