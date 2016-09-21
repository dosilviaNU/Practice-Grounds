/**
 * Created by David on 8/2/2016.
 */
import java.io.*;
import java.util.*;

public class Solution {

  public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    Scanner scan = new Scanner(System.in);
    int t = scan.nextInt();
    while(t>0){
      String s = scan.next();
      function:{for(int i = 1;i<s.length();i++){
        int j = (s.length()-1)-i;
          char a = s.charAt(i);
          char b = s.charAt(i-1);
          char c = s.charAt(j);
          char d = s.charAt(j+1);
          if(Math.abs(a-b) != Math.abs(c-d)){
            System.out.println("Not Funny");
            break function;
          }
      }
        System.out.println("Funny");
      }
      t--;
    }
  }
}