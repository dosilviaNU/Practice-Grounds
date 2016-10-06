package com.company;

/**
 * Created by David on 5/15/2016.
 */
public class ExpFib {

  public static void main(String[] args) {

    for (int j = 0; j < args.length; j++) {
      long start = System.nanoTime();
      int number = Integer.parseInt(args[j]);
      long f = ExpFib.expFib(number);



      long end = System.nanoTime();
      long total = end - start;

      System.out.println("Input Size: " + number);
      System.out.println(f);
      System.out.println("Time Taken: " + java.time.Duration.ofNanos(total).toString());
      System.out.println();
    }


  }

  public static long expFib(int number){
    if(number == 0){
      return 0;
    }
    else if(number == 1 ){
      return 1;
    }
    else {
      return expFib(number - 1  ) + expFib(number - 2);
    }
  }

}

