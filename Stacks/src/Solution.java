/**
 * Created by David on 7/27/2016.
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.regex.*;

public class Solution {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n1 = in.nextInt();
    int n2 = in.nextInt();
    int n3 = in.nextInt();
    int h1[] = new int[n1];
    for(int h1_i=0; h1_i < n1; h1_i++){
      h1[h1_i] = in.nextInt();
    }
    int h2[] = new int[n2];
    for(int h2_i=0; h2_i < n2; h2_i++){
      h2[h2_i] = in.nextInt();
    }
    int h3[] = new int[n3];
    for(int h3_i=0; h3_i < n3; h3_i++){
      h3[h3_i] = in.nextInt();
    }

    ArrayBlockingQueue<Integer> stacks[] = new ArrayBlockingQueue [3];
    stacks[0] = buildQ(h1);
    stacks[1] = buildQ(h2);
    stacks[2] = buildQ(h3);


    int[] heights = new int[3];
    heights[0] = calcHeight(h1);
    heights[1] = calcHeight(h2);
    heights[2] = calcHeight(h3);


    while(!sameHeights(heights)){
      int index = tallestIndex(heights);
      heights[index] = heights[index] - stacks[index].remove();
    }


  }

  public static ArrayBlockingQueue<Integer>  buildQ(int[] h){
    ArrayBlockingQueue<Integer>  temp = new ArrayBlockingQueue<Integer>(h.length);
    for(int i:h){
      temp.add(i);
    }
    return temp;
  }

  public static int calcHeight(int[] h){
    int result = 0;
    for(int i = 0;i<h.length;i++){
      result+=h[i];
    }
    return result;
  }

  public static boolean sameHeights(int[] heights){
    boolean result = true;
    for(int i =1 ;i<heights.length;i++){
      result = result && (heights[i-1] == heights[i]);
    }
    return result;
  }

  public static int tallestIndex(int[] heights){
    int index = 0;
    int max = 0;
    for(int i = 0;i<heights.length;i++){
      if(heights[i]>max){
        max = heights[i];
        index = i;
      }
    }
    return index;
  }
}


