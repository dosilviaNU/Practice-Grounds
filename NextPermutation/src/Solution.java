/**
 * Created by David on 8/1/2016.
 */
import java.io.*;
import java.util.*;

public class Solution {

  public static char[] chars;

  public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    Scanner scan = new Scanner(System.in);
    int t = scan.nextInt();
    scan.nextLine();
    while(t>0){
      String s = scan.nextLine();
      chars = s.toCharArray();
      if(nextPermutation()){
        s = new String(chars);
        System.out.println(s);
      }
      else{
        System.out.println("no answer");
      }
      t--;
    }
  }

  public static boolean nextPermutation(){
    int i = chars.length-1;
    while(i>0 && chars[i-1]>chars[i]){
      i--;
    }
    if(i == 0){
      return false;
    }
    else{
      int j = chars.length-1;
      while(chars[j]<=chars[i-1]&&j>=1){
        j--;
      }
      char temp = chars[i-1];
      chars[i-1]=chars[j];
      chars[j]=temp;
      j = chars.length-1;
      while(i<j){
        temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
        i++;
        j--;
      }
      return true;
    }
  }




}