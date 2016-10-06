import java.util.ArrayList;

/**
 * Created by David on 6/10/2016.
 */
public class Amortized {
  public static ArrayList<Long> amortizedList;
  public static long startTime;
  public static long endTime;
  public static long totalTime;

  public Amortized(){

  }

  public static void main(String[] args){
    amortizedList = new ArrayList<Long>();
    totalTime=0;
    for(int i = 0;i<3000000;i++){
      startTime = System.nanoTime();
      amortizedList.add(totalTime);
      endTime = System.nanoTime();
      totalTime =(endTime-startTime);
    }
    String output = buildText();
    System.out.print(output);
  }


  public static String buildText(){
    StringBuilder sb = new StringBuilder();
    for(int i = 0;i<amortizedList.size();i+=30){
      sb.append(i+"="+amortizedList.get(i)+"\n");
    }
    return sb.toString();
  }





}
