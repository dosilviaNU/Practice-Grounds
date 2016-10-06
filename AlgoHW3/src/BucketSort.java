import java.util.ArrayList;
import java.util.Random;

/**
 * Created by David on 5/31/2016.
 */

//Class to represent a bucket sort.
public class BucketSort {
  static ArrayList<Double> randArray = new ArrayList<Double>();
  static Random rand = new Random();


  //One argument is an integer representing the size of the array to be sorted.
  public static void main(String[] args) {
    int nSize;
    randArray = new ArrayList<Double>();
    if (args.length == 0) {
      System.exit(0);
    } else if (args.length == 1) {
      nSize = Integer.valueOf(args[0]);
      buildArray(nSize);
      long startTime = System.nanoTime();
      randArray = bucketSort(randArray);
      long endTime = System.nanoTime();
      long totalTime = (endTime-startTime)/1000000;
      System.out.print( totalTime + " milliseconds");
      if(nSize <= 100){
        for(Double dubya:randArray){
          System.out.println(dubya);
        }
      }
    }
  }

  //Builds an array of size n of random doubles.
  private static void buildArray(int nSize) {
    randArray = new ArrayList<Double>();
    for (int i = 0; i < nSize; i++) {
      randArray.add(rand.nextDouble());
    }
  }

  //Performs the bucket sort.
  private static ArrayList<Double> bucketSort(ArrayList<Double> sort){
    ArrayList<Double> sortedList = new ArrayList<Double>();
    ArrayList<ArrayList<Double>> buckets = buildBucket(sort.size()); //Build the buckets.
    for(Double dubya:sort){
      int bucketIndex = (int)Math.floor(dubya*sort.size()); //Calculate the index of the bucket.
      buckets.get(bucketIndex).add(dubya); //Place the value in the correct bucket.
    }
    for(ArrayList<Double> dubyas:buckets){
      if(dubyas.size() > 1){
        sortedList.addAll(Quicksort.qSort(dubyas)); //If more than one item in the bucket,
        //sort those items and add to the end of the sorted list.
      }
      else{
        sortedList.addAll(dubyas); //Add the item to the end of the list.
      }
    }
    return sortedList; //Return the sorted list.
  }

  //Builds the buckets.
  private static ArrayList<ArrayList<Double>> buildBucket(int size){
    ArrayList<ArrayList<Double>> buckets = new ArrayList<ArrayList<Double>>();

    for(int i = 0; i < size;i++){
      buckets.add(new ArrayList<Double>());
    }
    return buckets;
  }
}


