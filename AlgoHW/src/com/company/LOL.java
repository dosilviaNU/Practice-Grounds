package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;

/**
 * Created by David on 5/15/2016.
 */
public class LOL {

  public static void main(String[] args) {

    int input = Integer.parseInt(args[0]);
    int arraySize = Integer.parseInt(args[0]) - 1;
    LinkedList<LinkedList<Integer>> rows = new LinkedList<LinkedList<Integer>>();
    Random r = new Random();

     for(int i = 0; i< arraySize; i ++) {
       LinkedList<Integer> numbers = new LinkedList<Integer>();
       for (int j = 0; j < arraySize; j++) {
         numbers.add(r.nextInt(10));
       }
       rows.add(numbers);
     }




    long start = System.nanoTime();
    int sum = LOL.randomSum(rows);
    long end = System.nanoTime();
    long total = end - start;

    System.out.println("Input Size: " + input);

    System.out.println("Time Taken: " + java.time.Duration.ofNanos(total).toString());
    System.out.println("Sum: " + sum);
    System.out.println();



  }

  public static int randomSum(LinkedList<LinkedList<Integer>> rows){
    int countdown = 1000000;
    int sum = 0;
    Random r = new Random();
    while(countdown != 0){
      int find = r.nextInt(10);
      for(int i = 0; i < rows.size(); i++){
        LinkedList<Integer> numbers = rows.get(i);
        for(int j = 0; j < numbers.size(); j ++){
          if(numbers.get(j) == find){
            sum = sum + numbers.get(j);
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
