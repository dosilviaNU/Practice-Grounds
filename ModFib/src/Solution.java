/**
 * Created by David on 7/30/2016.
 */
import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class Solution {

  public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    Scanner scan = new Scanner(System.in);

    int a = scan.nextInt();
    int b = scan.nextInt();
    int n = scan.nextInt();

    BigInteger prev = BigInteger.valueOf(a);
    BigInteger cur = BigInteger.valueOf(b);

    for(int i = 2;i<n;i++){
      BigInteger temp = cur;
      cur = cur.multiply(cur).add(prev);
      prev = temp;
    }
    System.out.print(cur);

  }
}