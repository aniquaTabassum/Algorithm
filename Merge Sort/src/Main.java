
import java.util.Scanner;

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

    public static void mergeSort(int[] array, int startIndex, int endIndex) {
        if (startIndex < endIndex) {
            int mid = (startIndex + endIndex) / 2;
            //System.out.println("mid is "+mid);
            mergeSort(array, startIndex, mid);
            mergeSort(array, mid + 1, endIndex);
            merge(array, startIndex, mid, endIndex);
        }
    }

    public static void merge(int[] array, int startIndex, int mid, int endIndex) {
        int n1 = mid - startIndex + 1;
        int n2 = endIndex - mid;
        //System.out.println("n1 and n2 and mid is "+n1+" "+n2+" "+mid);
        int[] left = new int[n1 + 1];
        int[] right = new int[n2 + 1];
        for (int i = 0; i < n1; ++i) {
            left[i] = array[startIndex + i];
        }
        for (int j = 0; j < n2; ++j) {
            right[j] = array[mid + 1 + j];
        }
        left[n1] = Integer.MAX_VALUE;
        right[n2] = Integer.MAX_VALUE;
        int j = 0;
        int i = 0;
        int k = startIndex;
        while (i < n1 || j < n2) {
            if (left[i] <= right[j]) {
                array[k] = left[i];
                i += 1;
            } else {
                array[k] = right[j];
                j += 1;
            }
            k += 1;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = sc.nextInt();
        }
        mergeSort(array, 0, size - 1);
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println("");
    }
}
