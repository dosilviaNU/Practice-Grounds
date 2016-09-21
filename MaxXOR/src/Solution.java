/**
 * Created by David on 8/1/2016.
 */
import java.io.*;
import java.util.*;

public class Solution {

  public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    Scanner scan = new Scanner(System.in);
    int l = scan.nextInt();
    int r = scan.nextInt();
    int max = 0;
    for(int i = l;i<=r;i++){

      for(int j = l;j<=r;j++){
        int temp=0;
        int tempL = i;
        int tempR = j;
        int index = 0;
        while(tempR>=1||tempL>=1){
          if((tempL%2)!=(tempR%2)){
            temp = temp + (int)Math.pow(2,index);
          }
          tempL = tempL/2;
          tempR=tempR/2;
          index++;
        }
        max = Math.max(temp,max);

      }
    }
    System.out.println(max);
  }
}