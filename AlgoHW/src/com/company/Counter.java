package com.company;

/**
 * Created by David on 5/28/2016.
 */
public class Counter {
  int[] count;
  static int equivalences;
  Counter(){

  }
  public static void main(int[] args){
    equivalences = 0;
    count(args);
   System.out.print(equivalences);
  }


  public static int count(int[] stuff){
    int length = stuff.length;
    if(stuff.length <= 1){
      return  stuff[0];
    }
    else{
      if(count(stuff.))
    }
  }
}
