/**
 * Created by David on 7/27/2016.
 */
import java.io.*;
import java.util.*;

public class Solution {

  public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    Scanner scan = new Scanner(System.in);
    int array[] = new int[1000010];
    int n = scan.nextInt();
    for(int i = 0;i<n;i++){
      int thing = scan.nextInt();
      array[thing] = array[thing] - thing;
    }
    int m = scan.nextInt();
    for(int i = 0;i<m;i++){
      int thing = scan.nextInt();
      if(array[thing]!=thing) {
        array[thing] = array[thing] + thing;
      }
    }
    for(int i=0;i<array.length-1;i++){
      if(array[i] > 0){
        System.out.print(array[i]+" ");
      }
    }
    if(array[array.length-1] > 0){
      System.out.print(array[array.length-1]);
    }

  }
}