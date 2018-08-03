
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author hp
 */
public class Main {

    static PriorityQueue<Nodes> pq;
    static String s;
    static Map<Character, Integer> map;
    static Map<Character, String> mapForCodes;
    static String encoded = "";
    static Nodes rootOfTheTree;

    public static class Nodes implements Comparable<Nodes> {

        int frequency;
        char c;
        Nodes left = null;
        Nodes right = null;
        String code = "";

        public Nodes() {
        }

        public Nodes(char c, int frequency, Nodes left, Nodes right) {
            this.c = c;
            this.frequency = frequency;
            this.left = new Nodes();
            this.left = left;
            this.right = new Nodes();
            this.right = right;
        }

        @Override
        public int compareTo(Nodes t) {

            return this.frequency - t.frequency;
        }
    }

    public static void findFrequency() {
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {

            }
        }
    }
    static int count = 0;

    public static void generateCodes(Nodes root) {

        if (root.left != null) {
            if (root.equals(rootOfTheTree)!=true) {
                root.left.code = root.code + "0";

            } else {
              //  System.out.println("e");
                root.left.code += "0";
                count += 1;
            }
           // System.out.println("in left. code is " + root.left.code);
            generateCodes(root.left);
        }
        if (root.right != null) {
            if (root.equals(rootOfTheTree)!=true) {

                root.right.code = root.code + "1";
            } else {
                root.right.code += "1";
                count += 1;
            }
            //System.out.println("in right. code is "+code);
            generateCodes(root.right);
        }
        if (root.left == null && root.right == null) {

            mapForCodes.put(root.c, root.code);
            // System.out.println("code is " + code);
            System.out.println(root.c + " " + mapForCodes.get(root.c));
        }
    }

    public static void encode()
    {
        for(int i=0;i<s.length();i++)
        {
            char c = s.charAt(i);
            encoded+=mapForCodes.get(c);
        }
    }
    public static void main(String[] args) {
        pq = new PriorityQueue<Nodes>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string: ");
        map = new HashMap<Character, Integer>();
        s = sc.nextLine();
        //sc.next();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch) != true) {
                map.put(ch, 1);
            } else {
                map.put(ch, map.get(ch) + 1);
            }
        }
        for (Character key : map.keySet()) {
            System.out.println(key + " " + map.get(key));
            pq.add(new Nodes(key, map.get(key), null, null));
        }
        int number = 1;
        while (pq.size() > 1) {

           // System.out.println("?");
            Nodes n1 = new Nodes();
            n1 = pq.remove();
            Nodes n2 = new Nodes();
            n2 = pq.remove();
            Nodes n = new Nodes(Character.MIN_VALUE, (n1.frequency + n2.frequency), n1, n2);
            pq.add(n);

        }

        rootOfTheTree = new Nodes();
        rootOfTheTree = pq.remove();
        mapForCodes = new HashMap<Character, String>();
        generateCodes(rootOfTheTree);
        encode();
        System.out.println(encoded);
    }
}
