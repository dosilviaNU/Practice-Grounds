import java.util.Scanner;

/**
 * Created by David on 9/10/2016.
 */
public class Factorial {

  public static void main(String[] args){
    Scanner scan = new Scanner(System.in);
    int x = scan.nextInt();
    System.out.println(fact(x));
    System.exit(0);
  }

  public static int fact(int x){
    if(x == 0){
      return 1;
    }
    else{
      return x * fact(x-1);
    }
  }
}
