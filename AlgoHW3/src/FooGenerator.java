/**
 * Created by David on 5/28/2016.
 */
public class FooGenerator {
  public static void main(String[] args){
    int foos = Integer.valueOf(args[0]);
    System.out.print(generateFoos(foos, ""));
  }

  public static String generateFoos(int count , String accum){
    String foos = "";
    for(int i = 0;i < count+1;i++){
      foos = foos + "foo";
    }
    return foos;
  }

}
