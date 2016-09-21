/**
 * Created by David on 8/2/2016.
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
  public static String number;

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int k = in.nextInt();
    number = in.next();
    while(k>0){
      for(int i = 0;i<4;i++){
        int j = (n-1)-i;
        if(j<i){
          System.out.println(number);
          return;
        }
        char a = number.charAt(i);
        char b = number.charAt(j);
        if(a != b){
          swap(i, j);
          k--;
        }
      }

    }
  }

  public static void swap(int i, int j){
    char[] temp = number.toCharArray();
    char swap = temp[i];
    temp[j] =swap;
    number = String.valueOf(temp);
  }


}
