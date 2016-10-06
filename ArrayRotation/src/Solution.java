import java.io.*;
import java.util.*;

public class Solution {

  public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    int k = scan.nextInt()%n;
    int q = scan.nextInt();
    int nums[] = new int[n];
    for(int i = 0;i<n;i++){
      int num = scan.nextInt();
      nums[i] = num;
    }
    for(int i = 0;i<q;i++){
      int m = scan.nextInt();
      m = n-(Math.abs(m-k));
      System.out.println(nums[m]);
    }
  }
}