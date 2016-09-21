/**
 * Created by David on 8/2/2016.
 */
import java.io.*;
import java.util.*;

public class Solution {
  public static int[] nums;

  public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    int k = scan.nextInt();
    nums = new int[n];
    for(int i =0;i<n;i++){
      nums[i] = scan.nextInt();
    }
    int max = n;
    int place = 0;
    while(k>0 && place < n){
      int idx = maxIdx(place,max);
      if(place != idx) {
        swap(place, idx);
        k--;
      }
      max--;
      place++;

    }
    printArray(nums);
  }


  public static int maxIdx(int i,int n){
    while(nums[i]!=n){
      i+=1;
    }
    return i;
  }

  public static void swap(int i, int j){
    int swap = nums[i];
    nums[i] = nums[j];
    nums[j]=swap;
  }

  private static void printArray(int[] ar) {
    for(int n: ar){
      System.out.print(n+" ");
    }
    System.out.println("");
  }


}