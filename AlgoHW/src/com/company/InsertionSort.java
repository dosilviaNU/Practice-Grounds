package com.company;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by David on 5/15/2016.
 */
public class InsertionSort {


  public static void main(String[] args) {

    int arraySize = Integer.parseInt(args[0]);
    int[] numbers = new int[arraySize];
    Random r = new Random();


    for (int i = 0; i < numbers.length; i++) {
      numbers[i] = r.nextInt(1000000);
    }
    long start = System.nanoTime();
    numbers = InsertionSort.sortNumbers(numbers);
    long end = System.nanoTime();
    long total = end - start;

    System.out.println("Input Size: " + arraySize);

    System.out.println("Time Taken: " + java.time.Duration.ofNanos(total).toString());
    System.out.println(Arrays.toString(numbers));
    System.out.println();



  }


  public static int[] sortNumbers(int[] numbers) {
    for(int j = 1; j < numbers.length; j++){
      int key = numbers[j];
      int i = j-1;
      while(i >= 0 && numbers[i] > key ){
        numbers[i + 1] = numbers[i];
        i = i-1;
      }
      numbers[i+1] = key;
    }
    return numbers;
  }

}



