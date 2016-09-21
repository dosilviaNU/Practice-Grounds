/**
 * Created by David on 8/1/2016.
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
  public static int qs = 0;
  public static int is = 0;


  public static void insertionSort(int[] ar)
  {
    // Fill up the code for the required logic here
    // Manipulate the array as required
    // The code for Input/Output is already provided
    for(int i = 1;i<ar.length;i++){
      int j = i;
      while((j>0)&&(ar[j-1]>ar[j])){
        int swap = ar[j];
        ar[j]=ar[j-1];
        ar[j-1]=swap;
        j = j-1;
        is++;
      }
    }
  }



  public static void quicksort(int[] array, int lo, int hi) {
    if (hi <= lo) {
      qs++;
      return;
    }
    int j = partition(array, lo, hi);
    quicksort(array, lo, j - 1);
    quicksort(array, j + 1, hi);
  }

  public static int partition(int[] array, int lo, int hi) {
    int pivot = array[hi];
    int i = lo;
    for(int j = lo;j<hi;j++){
      if(array[j]<=pivot){
        int swap = array[i];
        array[i] = array[j];
        array[j] = swap;
        i++;
      }
    }
    int swap = array[i];
    array[i] = array[hi];
    array[hi] = swap;
    return i;
  }





  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int s = in.nextInt();
    int[] ar = new int[s];
    int[] ar2 = new int[s];
    for(int i=0;i<s;i++){
      ar[i]=ar2[i]=in.nextInt();
    }
    insertionSort(ar);
    qs++;
    quicksort(ar2, 0, s-1);
    printArray(ar);
    printArray(ar2);
    System.out.print(is+" "+qs);
  }


  private static void printArray(int[] ar) {
    for(int n: ar){
      System.out.print(n+" ");
    }
    System.out.println("");
  }


}




