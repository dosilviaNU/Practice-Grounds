import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by David on 5/28/2016.
 */
//Class to represent various types of quicksort.
public class Quicksort {
  static ArrayList<Double> randArray = new ArrayList<Double>();
  static Random rand = new Random();

  //Takes 1-2 arguments
  //optional first arguments are -l for lazy quicksort, -m for median of 3 quick sort
  //and -i for inplace quicksort, second argument in these cases will be the size of the
  //randomly generated array of doubles to be sorted,
  //if no optional first argument standard quicksort will occur and the integer pass will
  //represent the size of the random array of Doubles to be sorted.
  public static void main(String[] args) {
    long startTime;
    long endTime;
    long totalTime;
    int nSize;
    randArray = new ArrayList<Double>();
    if (args.length == 0) {
      System.exit(0);
    } else if (args.length == 1) {

      nSize = Integer.valueOf(args[0]);
      buildArray(nSize);
      startTime = System.nanoTime();
      randArray = qSort(randArray);
      endTime = System.nanoTime();
      totalTime = (endTime-startTime)/1000000;

      System.out.print(totalTime + " milliseconds");
      if(nSize <= 100){
        for(Double dubya:randArray){
          System.out.println(dubya);
        }
      }
    } else {
      nSize = Integer.valueOf(args[1]);
      buildArray(nSize);


      switch (args[0]) {
        case "-l":
          startTime = System.nanoTime();
          randArray =lazyQSort(randArray);
          endTime = System.nanoTime();
          totalTime = (endTime-startTime)/1000000;
          System.out.print(totalTime + " milliseconds");
          if(nSize <= 100){
            for(Double dubya:randArray){
              System.out.println(dubya);
            }
          }
          break;
        case "-m":
          startTime = System.nanoTime();
          randArray = median3QSort(randArray);
          endTime = System.nanoTime();
          totalTime = (endTime-startTime)/1000000;
          System.out.print(totalTime + " milliseconds");
          if(nSize <= 100){
            for(Double dubya:randArray){
              System.out.println(dubya);
            }
          }
          break;
        case "-i":
          startTime = System.nanoTime();
          inPlaceQSort(randArray, 0, randArray.size());
          endTime = System.nanoTime();
          totalTime = (endTime-startTime)/1000000;
          System.out.print(totalTime + " milliseconds");
          if(nSize <= 100){
            for(Double dubya:randArray){
              System.out.println(dubya);
            }
          }
          break;
      }
    }
  }

  //Build the array of random doubles.
  private static void buildArray(int nSize) {
    randArray = new ArrayList<Double>();
    for (int i = 0; i < nSize ; i++) {
      randArray.add(rand.nextDouble());
    }
  }

  //Standard quicksort, randomly picks pivot point.
  public static ArrayList<Double> qSort(ArrayList<Double> sort) {
    ArrayList<Double> small = new ArrayList<Double>();
    ArrayList<Double> large = new ArrayList<Double>();

    if(sort.size() <= 3){
      return sortThreeOrLess(sort);
    }

    int pivot = rand.nextInt(sort.size());
    Double pivotValue = sort.remove(pivot);
    for(Double dubya:sort){
      if(pivotValue.compareTo(dubya) > 0){
        small.add(dubya);
      }
      else{
        large.add(dubya);
      }
    }

    return merge(qSort(small), pivotValue, qSort(large));
}

  //Lazy quicksort, pivot is always first element of the array.
  public static ArrayList<Double> lazyQSort(ArrayList<Double> sort) {
    ArrayList<Double> small = new ArrayList<Double>();
    ArrayList<Double> large = new ArrayList<Double>();
    if(sort.size() <= 3){
      return sortThreeOrLess(sort);
    }
    int pivot = rand.nextInt(sort.size());
    Double pivotValue = sort.remove(0);
    for(Double dubya:sort){
      if(pivotValue.compareTo(dubya) > 0){ //Smaller than pivot value.
        small.add(dubya); //Add to smalls.
      }
      else{
        large.add(dubya); //Else add to bigs.
      }
    }

    return merge(lazyQSort(small), pivotValue, lazyQSort(large)); //Merge the recursive call
    //on smalls, the picot value and the recursive call on large.
  }

  //Median of 3, pivot is the median of the values at 0, n/2 and n-1.
  public static ArrayList<Double> median3QSort(ArrayList<Double> sort) {
    ArrayList<Double> small = new ArrayList<Double>();
    ArrayList<Double> large = new ArrayList<Double>();
    ArrayList<Double> median = new ArrayList<Double>();
    if(sort.size() <= 3){
      return sortThreeOrLess(sort);
    }
    int pivot = rand.nextInt(sort.size());
    //Remove the 3 values to find the median from.
    Double low = sort.remove(0);
    Double mid = sort.remove(sort.size()/2);
    Double high = sort.remove(sort.size()-1);
    //Add them to a median array.
    median.add(low);
    median.add(mid);
    median.add(high);
    //Sort this array.
    median = sortThreeOrLess(median);
    //Remove the first element, add it to the array to be sorted.
    sort.add(median.remove(0));
    //Remove the last element, add it to the array to be sorted.
    sort.add(median.remove(1));
    Double pivotValue = median.remove(0); //Remove the remaining value and set it as the pivot
    // value.
    for(Double dubya:sort){
      if(pivotValue.compareTo(dubya) > 0){
        small.add(dubya); //Place in smalls
      }
      else{
        large.add(dubya); //Place in the large.
      }
    }

    return merge(median3QSort(small), pivotValue, median3QSort(large));//Merge the recursive call
    //on small, the picot value and the recursive call on large.
  }


  //Quicksort without the need for additional arrays, sort is done in place through indices.
  //Work in progress.
  private static void inPlaceQSort(ArrayList<Double> sort, int lo, int hi){
    if(hi < lo){return;}

    if(hi-lo  <= 3){
      sortThreeOrLessInPlace(sort, lo, hi-1);
      return;
    }
    if(hi == lo){return;}
    int pivotIndex = rand.nextInt(hi) + lo;
    Double pivotValue = sort.remove(pivotIndex);
    sort.add(pivotValue);
    int bG = lo;
    for(int i = lo;i < hi; i++){
      if(sort.get(i).compareTo(pivotValue) < 0){
        Double small = sort.get(i);
        Double bigger = sort.get(bG);
        sort.set(i, small);
        sort.set(bG, bigger);
        if(bG < hi){bG +=1;}else{break;}
      }
    }
    Double bgValue = sort.remove(bG);
    pivotValue = sort.get(sort.size() - 1);
    sort.add(bgValue);
    sort.set(bG, pivotValue);
    inPlaceQSort(sort, lo, bG);
    inPlaceQSort(sort, bG + 1, hi);
  }

//Merges an two array lists with a single value in the middle.
private static ArrayList<Double> merge(ArrayList<Double> small, Double pivot,
                                       ArrayList<Double> large) {
  ArrayList<Double> merged = small;
  merged.add(pivot);
  merged.addAll(large);
  return merged;
}


  //Massive if/else to sort a list of 3 or less elements.
  private static ArrayList<Double> sortThreeOrLess(ArrayList<Double> sort){
    if (sort.size() <= 3) {
      if (sort.size() == 0) {
        return sort;
      } else if (sort.size() == 1) {
        return sort;
      } else if (sort.size() == 2) {
        if (sort.get(0).compareTo(sort.get(1)) < 0) {

        } else {
          Double first = sort.get(0);
          Double second = sort.get(1);
          sort.set(0, second);
          sort.set(1, first);
        }
      } else {
        Double first = sort.get(0);
        Double second = sort.get(1);
        Double third = sort.get(2);
        if (first.compareTo(second) < 0) {
          if (first.compareTo(third) < 0) {
            if (second.compareTo(third) < 0) {
              return sort;
            } else {
              sort.set(1, third);
              sort.set(2, second);
            }
          } else {
            sort.set(0, third);
            sort.set(1, first);
            sort.set(2, second);
          }
        } else {
          if (second.compareTo(third) < 0) {
            if (first.compareTo(third) < 0) {
              sort.set(0, second);
              sort.set(1, first);
              return sort;
            } else {
              sort.set(0, second);
              sort.set(1, third);
              sort.set(2, first);
            }
          } else {
            sort.set(0, third);
            sort.set(1, second);
            sort.set(2, first);
          }
        }
      }
    }
    return sort;
  }


  //ATTEMPT at an inplace sorting of 3 or less elements.
  private static void sortThreeOrLessInPlace(ArrayList<Double> sort, int lo, int hi){
    if (hi - lo <= 3) {
      if (hi - lo == 0) {
          return;
      } else if (hi - lo == 1) {
          return;
      } else if (hi - lo ==  2) {
        if (sort.get(lo).compareTo(sort.get(hi)) < 0) {
          return;
        } else {
          Double first = sort.get(lo);
          Double second = sort.get(hi);
          sort.set(lo, second);
          sort.set(hi, first);
          return;
        }
      } else {
        int mid = lo + 1;
        Double first = sort.get(lo);
        Double second = sort.get(mid);
        Double third = sort.get(hi);
        if (first.compareTo(second) < 0) {
          if (first.compareTo(third) < 0) {
            if (second.compareTo(third) < 0) {
              return;
            } else {
              sort.set( mid, third);
              sort.set(hi, second);
              return;
            }
          } else {
            sort.set(lo, third);
            sort.set(mid, first);
            sort.set(hi, second);
            return;
          }
        } else {
          if (second.compareTo(third) < 0) {
            if (first.compareTo(third) < 0) {
              sort.set(lo, second);
              sort.set(mid, first);
              return;
            } else {
              sort.set(lo, second);
              sort.set(mid, third);
              sort.set(hi, first);
              return;
            }
          } else {
            sort.set(lo, third);
            sort.set(mid, second);
            sort.set(hi, first);
            return;
          }
        }
      }
    }
    return;
  }








}
















