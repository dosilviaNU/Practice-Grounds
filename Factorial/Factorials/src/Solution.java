/**
 * Created by David on 7/27/2016.
 */
import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class Solution {

  public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    Scanner scan = new Scanner(System.in);
    long n = (long)scan.nextInt();
    BigInteger big = BigInteger.valueOf(n);
    System.out.println(factorial(n));
  }

  public static long factorial(long n){
    if(n == 1){
      return 1;
    }
    else{
      return n*factorial(n-1);
    }
  }
}