
import java.util.Scanner;


public class Main {
    
    public static int partition(int[] array, int startIndex, int endIndex)
    {
        int pivot = array[endIndex];
        int pIndex = startIndex;//it will refer to the first index of the array
        for(int i=startIndex; i<endIndex;i++)//will check from the first index until the pivot;
        {
            if(array[i] <= pivot)
            {
                int temp = array[i];
                array[i] = array[pIndex];
                array[pIndex] = temp;
                pIndex+=1;
            }
        }
        int temp2 = array[pIndex];
        array[pIndex] = array[endIndex];
        array[endIndex] = temp2;
        return pIndex;
    }
    public static void quickSort(int[] array, int startIndex, int endIndex)
    {
        if(startIndex<endIndex)
        {
            int pIndex = partition(array, startIndex, endIndex);
            quickSort(array, startIndex, pIndex-1);
            quickSort(array,  pIndex+1, endIndex);
        }
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        
        int size;
        size = sc.nextInt();
        int[] array = new int[size];
        for(int i=0;i<size;i++)
            array[i] = sc.nextInt();
        quickSort(array, 0, size-1);
        
         for(int i=0;i<size;i++)
            System.out.print(array[i]+" ");
         System.out.println("");
    }
}
