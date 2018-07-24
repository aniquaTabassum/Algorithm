
import java.util.Scanner;
import java.util.Vector;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hp
 */
public class Practice {
    static Vector<Vector<Integer>> map;
    static boolean[] visited;
    static int nodes;
    static int edges;
    public static void dfs()
    {
        initialise();
        for(int i=0;i<nodes;i++)
        {
            if(visited[i] == false)
                dfsVisit(i);
        }
    }
    public static void initialise()
    {
        for(int i=0;i<nodes;i++)
        {
            visited[i] = false;
        }
    }
    public static void dfsVisit(int node)
    {
        visited[node] = true;
        for(int i=0;i<map.get(node).size();i++)
        {
            if(visited[map.get(node).get(i)] == false)
            {
                //visited[map.get(node).get(i)] = true;
                dfsVisit(map.get(node).get(i));
            }
        }
        //visited[node] = true;
        System.out.println(node+" ");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        nodes = sc.nextInt();
        edges = sc.nextInt();
        visited = new boolean[nodes];
        map = new Vector<Vector<Integer>>(nodes);
        for(int i=0;i<nodes;i++)
            map.add(new Vector<Integer>());
        for(int i=0;i<edges;i++)
        {
            int x = sc.nextInt();
            int y = sc.nextInt();
            map.get(x).add(y);
            map.get(y).add(x);
        }
        dfs();
        
    }
}
