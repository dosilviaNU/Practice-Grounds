/**
 * Created by David on 7/27/2016.
 */
import java.io.*;
import java.util.*;

public class Solution {

  public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    Scanner scan = new Scanner(System.in);
    int t = scan.nextInt();
    while(t>0){
      int m = scan.nextInt();
      int n = scan.nextInt();
      int prices[] = new int[n];
      for(int i = 0;i<n;i++){
        prices[i] = scan.nextInt();
      }


      search:{for(int i = 0;i<n;i++){
        int p1 = prices[i];
        for(int j = 0;j<n;j++){
          int p2 = prices[j];
          if((i!=j)&&((p1+p2)==m)){
            System.out.println((i+1)+" "+(j+1));
            break search;
          }
        }

      }}
      t--;
    }
  }
}