package com.company;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

/**
 * Created by David on 5/15/2016.
 */
public class QuickSort {
  public static void main(String[] args) {

    int arraySize = Integer.parseInt(args[0]);
    int[] numbers = new int[arraySize];
    Random r = new Random();


    for (int i = 0; i < numbers.length; i++) {
      numbers[i] = r.nextInt(1000000);
    }
    long start = System.nanoTime();
    Arrays.sort(numbers);
    long end = System.nanoTime();
    long total = end - start;

    System.out.println("Input Size: " + arraySize);

    System.out.println("Time Taken: " + java.time.Duration.ofNanos(total).toString());
    System.out.println(Arrays.toString(numbers));
    System.out.println();



  }


}
