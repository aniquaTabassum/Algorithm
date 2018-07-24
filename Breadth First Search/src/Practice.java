
import java.util.LinkedList;
import java.util.Queue;
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
   static Vector<Vector<Integer>> v;
    static int nodes;
    static int edges;
    static boolean[] visited;
    public static void bfs(int n)
    {
        initialize();
        visited[n] = true;
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(n);
        while(q.isEmpty()!=true)
        {
            int s = q.peek();
            System.out.println(s);
            q.remove();
            for(int i=0;i<v.get(s).size();i++)
            {
                if(visited[v.get(s).get(i)] == false)
                {
                    visited[v.get(s).get(i)] = true;
                    q.add(v.get(s).get(i));
                }
            }
        }
    }
    public static void initialize()
    {
        for(int i=0;i<nodes;i++)
            visited[i] = false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        nodes = sc.nextInt();
        edges = sc.nextInt();
        visited = new boolean[nodes];
        v = new Vector<Vector<Integer>>(nodes);
        for(int i=0;i<nodes;i++)
            v.add(new Vector<Integer>());
        for(int i=0;i<edges;i++)
        {
            int x = sc.nextInt();
            int y = sc.nextInt();
            v.get(x).add(y);
        }
        bfs(0);
    }
}
