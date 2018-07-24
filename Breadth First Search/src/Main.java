
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
 * @author Aniqua Tabassum
 */
public class Main {

    static Vector<Vector<Integer>> map;
    static int nodes;
    static int edges;
    static boolean[] visted;
    public static void initialise()
    {
        for(int i=0;i<visted.length;i++)
            visted[i] = false;
    }
    public static void bfs(int root)
    {
        initialise();
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(root);
        visted[root]=true;
        while (q.isEmpty()==false) {   
            int print = q.peek();
            System.out.println(print+" ");
            q.remove();
            for(int i=0;i<map.get(print).size();i++)
            {
                if(visted[map.get(print).get(i)] == false)
                {
                    q.add(map.get(print).get(i));
                    visted[map.get(print).get(i)] = true;
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        nodes = sc.nextInt();
        edges = sc.nextInt();
        visted = new boolean[nodes];
        map = new Vector<Vector<Integer>>(nodes);
        for(int i=0;i<nodes;i++)
            map.add(new Vector<Integer>());
        for(int i=0;i<edges;i++)
        {
            int x = sc.nextInt();
            int y = sc.nextInt();
            map.get(x).add(y);
        }
        bfs(0);
    }
}