package com.company;

import java.util.LinkedList;
import java.util.Random;

/**
 * Created by David on 5/15/2016.
 */
public class My2DArray {
  public static void main(String[] args) {

    int input = Integer.parseInt(args[0]);
    int[][] numberArray = new int[input][input];

    Random r = new Random();

    for(int i = 0; i< input; i ++) {
      for (int j = 0; j < input; j++) {
        numberArray[i][j] = (r.nextInt(10));
      }
    }




    long start = System.nanoTime();
    int sum = My2DArray.randomSum(numberArray);
    long end = System.nanoTime();
    long total = end - start;

    System.out.println("Input Size: " + input);

    System.out.println("Time Taken: " + java.time.Duration.ofNanos(total).toString());
    System.out.println("Sum: " + sum);
    System.out.println();



  }

  public static int randomSum(int[][] numberArray){
    int countdown = 1000000;
    int sum = 0;
    Random r = new Random();
    while(countdown != 0){
      int find = r.nextInt(10);
      for(int i = 0; i < numberArray.length; i++){
        for(int j = 0; j < numberArray.length; j ++){
          if(numberArray[i][j] == find){
            sum = sum + numberArray[i][j];
          }
          break;
        }
        break;
      }
      countdown = countdown - 1;
    }
    return sum;
  }
}
