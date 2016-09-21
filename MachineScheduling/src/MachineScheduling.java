import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LongSummaryStatistics;
import java.util.Random;

/**
 * Created by David on 6/18/2016.
 */

/**
 * Class to compute machine scheduling using both an approximation method
 * and a brute force method to get the optimal solution.
 */
public class MachineScheduling {
  private static double [] jobArray;
  private static double greedyMax;
  private static double optimalMax;

  /**
   * Takes an integer from 1-62 as an input.
   * @param args integer from 1-62 as an input.
   */
  public static void main(String[] args){
    if(args.length <1){
      System.exit(0);
    }
    int arraySize = Integer.valueOf(args[0]);

    //Build the array of random job lengths. Then sort it greatest->least.
    jobArray = new double[arraySize];
    buildJobArray();
    sort();

    //Start the greedy appoximation algo.
    Long greedyStartTime = System.nanoTime();
    boolean[] greedySchedule = greedilySchedule(jobArray);
    sort();
    Long greedyEndTime = System.nanoTime();
    Long greedyTotalTime = greedyEndTime-greedyStartTime;
    //Print Results
    String iden=" nanoseconds.";
    if(greedyTotalTime>1000000){
      greedyTotalTime = greedyTotalTime/1000000;
      iden = " milliseconds.";
    }
    System.out.println("Greedy Approximation Method: ");
    System.out.println(greedyTotalTime+iden);
    System.out.println(machineStrings(greedySchedule));

    //Start the brute force method.
    Long optimalStartTime = System.currentTimeMillis();
    boolean[] optimalSchedule = optimallySchedule(jobArray);
    sort();
    Long optimalEndTime = System.currentTimeMillis();
    Long optimalTotalTime = optimalEndTime-optimalStartTime;
    iden=" milliseconds.";
    if(optimalTotalTime>1000000){
      optimalTotalTime = optimalTotalTime/60000;
      iden = " minutes.";
    }
    //Print the results.
    System.out.println("Brute Force Method: ");
    System.out.println(optimalTotalTime+iden);
    System.out.println(machineStrings(optimalSchedule));

    //Print the optimality ratio.
    System.out.println("Optimality Ratio: "+(greedyMax/optimalMax));
  }

  /**
   * Builds the array of random job lengths.
   */
  private static void buildJobArray(){
    Random rand = new Random();
    for(int i = 0;i < jobArray.length;i++){
      jobArray[i] = (rand.nextDouble() * 99) + 1;
    }
  }

  /**
   * Sort the job array from greatest to least.
   */
  private static void sort(){
    ArrayList<Double> sort = new ArrayList<Double>(jobArray.length);
    for(double dub:jobArray){
      sort.add(dub);
    }
    Collections.sort(sort);
    Collections.reverse(sort);
    for(int i = 0;i<jobArray.length;i++){
      jobArray[i] = sort.get(i);
    }
  }

  /**
   * Greedy approximation algorithm.
   * @param jobs Array of job times as doubles.
   * @return Boolean array where true represents Machine 1, and false represents Machine 2.
   */
  private static boolean[] greedilySchedule(double[] jobs){
    double machine1 = 0.0;
    double machine2 = 0.0;
    boolean[] schedule = new boolean[jobs.length];
    schedule[0] = true;
    machine1 = machine1+jobs[0];
    for(int i = 1;i<jobs.length;i++){
      if(machine1<machine2){
        schedule[i] = true;
        machine1 = machine1+jobs[i];
      }
      else{
        schedule[i] = false;
        machine2 = machine2+jobs[i];
      }
    }
    greedyMax = Math.max(machine1, machine2);
    return schedule;
  }

  /**
   * Brute force algorithm.
   * @param jobs Array of job times as doubles.
   * @return Boolean array where true represents Machine 1, and false represents Machine 2.
   */
  private static boolean[] optimallySchedule(double[] jobs) {
    long counter = (long) Math.pow(2, jobs.length) - 1;
    boolean[] optimal = new boolean[jobs.length];
    double bestTime = Double.MAX_VALUE;


    while(counter > 0){
      double m1 = 0.0;
      double m2 = 0.0;
      boolean[] temp = new boolean[jobs.length];
      long tracker = counter;
      for (int i = 0; i < jobs.length; i++) {
        long bit = tracker%2;
        if (bit >= 1) {
          temp[i] = true;
          m1 = m1 + jobs[i];
        } else {
          m2 = m2 + jobs[i];
        }
        tracker = tracker / 2;}
      double tempTime = Math.max(m1, m2);
      if (bestTime > tempTime) {
        bestTime = tempTime;
        optimal = temp;
      }
      counter=counter-1;
    }
    optimalMax = calcBestTime(optimal);
    return optimal;
  }


  //Returns the latest Machines end time.
  private static double calcBestTime(boolean[] schedule){
    double m1 = 0.0;
    double m2 = 0.0;
    for(int i = 0;i<jobArray.length;i++){
      if(schedule[i]){
        m1 = m1+jobArray[i];
      }
      else{
        m2 = m2+jobArray[i];
      }
    }
    return Math.max(m1, m2);
  }

  //Returns the string of Machine results.
  private static String machineStrings(boolean[] schedule){
    double m1 = 0.0;
    double m2 = 0.0;
    for(int i = 0;i<jobArray.length;i++){
      if(schedule[i]){
        m1 = m1+jobArray[i];
      }
      else{
        m2 = m2+jobArray[i];
      }
    }
    return "Machine 1: "+m1+" Machine 2: " + m2;
  }







}

