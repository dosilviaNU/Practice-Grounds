import java.io.*;
import java.util.*;

public class Solution {

  public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    Scanner scan = new Scanner(System.in);
    int t = scan.nextInt();
    while (t>0){
      int s = scan.nextInt();
      int a = scan.nextInt();
      int b = scan.nextInt();

      StringBuilder sb = new StringBuilder();

      int n = s-1;
      int i = n;
      ArrayList<Long> ans = new ArrayList<Long>();
      while(n>=0){
        int pile1 = i-n;
        int pile2 = n;
        long total = pile1*a + pile2*b;
        if(!ans.contains(total)){
          ans.add(total);
        }
        n--;
      }
      for(int j = 0;j<ans.size()-1;j++){
        sb.append(ans.get(j)+" ");
      }
      sb.append(ans.get(ans.size()-1));
      System.out.print(sb.toString());


      System.out.println();
      t--;

    }
  }
}
