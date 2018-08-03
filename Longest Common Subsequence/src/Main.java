

import java.io.*;
import java.util.Scanner;

class Main {

    static String X;
    static String xTemp;
    static String yTemp;
    static String Y;
    static int[][] L;
    static int m;
    static int n;
    static void createTable() {
         L = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    L[i][j] = 0;
                } else if (xTemp.charAt(i - 1) == yTemp.charAt(j - 1)) {
                    L[i][j] = L[i - 1][j - 1] + 1;
                } else {
                    L[i][j] = Math.max(L[i - 1][j], L[i][j - 1]);
                }
            }
        }
        
    }

    static void PrintLCS()
    {
        String lcs = "";
        int i = m, j = n;
        while (i > 0 && j > 0) {
            if (xTemp.charAt(i - 1) == yTemp.charAt(j - 1)) {
                lcs += X.charAt(i - 1);
                i--;
                j--;
                // index--;     
            } // If not same, then find the larger of two and
            // go in the direction of larger value
            else if (L[i - 1][j] > L[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }
        String lcs2 = "";
        i = m;
        j = n;
        while (i > 0 && j > 0) {
            if (xTemp.charAt(i - 1) == yTemp.charAt(j - 1)) {
                lcs2 += X.charAt(i - 1);
                i--;
                j--;
            } // If not same, then find the larger of two and
            // go in the direction of larger value
            else if (L[i - 1][j] >= L[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }
     
        System.out.print("LCS of " + X + " and " + Y + " is ");
        StringBuilder builder = new StringBuilder(lcs);
         System.out.println(builder.reverse() + " ");
         if(lcs2.equals(lcs)!=true){
        StringBuilder b2 = new StringBuilder(lcs2);
        b2.reverse();
             System.out.println(b2);
         }
    }
    // driver program
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         X = sc.nextLine();
         Y = sc.nextLine();
         xTemp = X.toLowerCase();
         yTemp = Y.toLowerCase();
         m = X.length();
         n = Y.length();
        createTable();
        PrintLCS();
    }
}
 
