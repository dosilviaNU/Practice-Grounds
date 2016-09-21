/**
 * Created by David on 7/29/2016.
 */
import java.io.*;
import java.util.*;
import java.math.BigInteger;
public class Solution {

  public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    Scanner scan = new Scanner(System.in);
    int t = scan.nextInt();
    while(t>0){
      int a = scan.nextInt();
      int b = scan.nextInt();
      int n = scan.nextInt();

      int count = 2;
      BigInteger bigA = BigInteger.valueOf(a);
      BigInteger bigB = BigInteger.valueOf(b);
      BigInteger bigK = BigInteger.ZERO;

      if((n==0)){
        bigK = bigA;
      }
      else if(n==1){
        bigK=bigB;
      }
      else{
        while(count <= n){
          BigInteger temp = bigA;
          bigK = bigB.add(bigA);
          bigA = bigB;
          bigB=bigK;
          count++;
        }
      }
      int mod = (int)(Math.pow(10,7)+7);

      bigK=bigK.mod(BigInteger.valueOf(mod));

      System.out.println(bigK);
      t--;


    }
  }
}