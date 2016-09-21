/**
 * Created by David on 7/29/2016.
 */
import java.io.*;
import java.util.*;

public class Solution {

  public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    int toys[] = new int[n];
    for(int i = 0;i<n;i++){
      toys[i] = scan.nextInt();
    }
    quicksort(toys, 0, n-1);

    for(int i = 0;i<toys.length;i++){
      System.out.print(toys[i]+ " ");
    }
    System.out.println();

  }

  public static void quicksort(int[] array, int lo, int hi ){
    if(hi<=lo){
      return;
    }
    int j = partition(array, lo, hi);
    quicksort(array,lo, j-1);
    quicksort(array,j+1,hi);
  }

  public static int partition(int[] array, int lo, int hi){
    int pivot = array[lo];
    int open=lo+1;
    int closed = lo;
    for(int i = lo+1;i<=hi;i++){
      int check = array[i];
      if(check < pivot){
        array[i] = array[open];
        array[open] = check;
        closed = open;
        open++;
      }
    }
    int swap = array[closed];
    if(swap<pivot) {
      array[closed] = pivot;
      array[lo] = swap;
    }
    return closed;
  }
}

