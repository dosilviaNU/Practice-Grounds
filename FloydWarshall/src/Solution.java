/**
 * Created by David on 7/30/2016.
 */
/**
 * Created by David on 7/30/2016.
 */
import java.io.*;
import java.util.*;

public class Solution {


  public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    int m = scan.nextInt();
    int[][] dist = new int[n+1][n+1];

    for(int i = 1;i<=n;i++){
      for(int j = 1;j<=n;j++){
        dist[i][j]=30000000;
      }
    }

    for(int i = 1;i<=n;i++){
      dist[i][i] = 0;
    }

    for(int i = 0;i<m;i++){
      int from = scan.nextInt();
      int to = scan.nextInt();
      int weight = scan.nextInt();
      dist[from][to] = weight;
    }

    for(int k = 1;k<=n;k++){
      for(int i = 1;i<=n;i++){
        for(int j= 1;j<=n;j++){
          if(dist[i][j] > dist[i][k]+dist[k][j]){
            dist[i][j] = dist[i][k]+dist[k][j];
          }
        }
      }
    }
    int q = scan.nextInt();
    for(int i = 0;i<q;i++){
      int from = scan.nextInt();
      int to = scan.nextInt();

      if(dist[from][to]!=30000000){
        System.out.println(dist[from][to]);
      }
      else{
        System.out.println(-1);
      }
    }
  }
}
