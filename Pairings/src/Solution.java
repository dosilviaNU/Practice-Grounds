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
    int m = scan.nextInt();
    scan.nextLine();
    boolean[][] bools = new boolean[n][m];
    for(int i = 0;i<n;i++){
      String s = scan.nextLine();
      for(int j = 0;j<m;j++){
        switch(s.charAt(j)){
          case '1': bools[i][j] = true;
            break;
          case '0':bools[i][j] = false;
            break;
          default:break;
        }
      }
    }

    int maxQ = 0;
    int maxT = 0;

    for(int i = 0;i<n-1;i++){
      for(int j = i+1;j<n;j++){
        int count = 0;
        for(int k = 0;k<m;k++){
          if(bools[i][k]||bools[j][k]){
            count++;
          }
        }
        if(count > maxQ){
          maxQ=count;
          maxT = 1;
        }
        else if(count == maxQ){
          maxT++;
        }
      }
    }

    System.out.println(maxQ);
    System.out.println(maxT);


  }
}
