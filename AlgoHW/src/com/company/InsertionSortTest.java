package com.company;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by David on 5/21/2016.
 */
public class InsertionSortTest {

  int[] notSorted = {4 , 5 ,2, 7, 1, 9};
  int[] sorted = {1, 2, 4, 5, 7, 9};

  @Test
  public void testSort(){
    InsertionSort sorter = new InsertionSort();
    notSorted = sorter.sortNumbers(notSorted);
    for(int i:notSorted){
      System.out.print(i);
    }
  }

}