/**
 * Created by David on 7/29/2016.
 */
import java.io.*;
import java.util.*;

public class Solution {

  public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    Scanner scan = new Scanner(System.in);
    int d1 = scan.nextInt();
    int m1 = scan.nextInt();
    int y1 = scan.nextInt();
    int d2 = scan.nextInt();
    int m2 = scan.nextInt();
    int y2 = scan.nextInt();

    int fine = 0;
    if((d1<=d2)&&(m1<=m2)&&(y1<=y2)){
    }
    else if(y1>y2){
      fine = 10000;
    }
    else if(m1>m2){
      fine = (m1-m2)*500;

    }
    else{
      fine = (d1-d2)*15;
    }
    System.out.println(fine);
  }
}