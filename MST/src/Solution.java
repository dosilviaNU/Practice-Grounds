/**
 * Created by David on 7/30/2016.
 */
import java.io.*;
import java.util.*;

public class Solution {

  public static ArrayList<Edge> edges = new ArrayList<Edge>();
  public static ArrayList<Edge> rem = new ArrayList<Edge>();
  public static HashMap<Integer,Integer> unions = new HashMap<Integer,Integer>();

  public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    int m = scan.nextInt();
    for(int i = 1;i<=n;i++){
      unions.put(i,i);
    }
    for(int i = 0;i<m;i++){
      int from = scan.nextInt();
      int to = scan.nextInt();
      int weight = scan.nextInt();
      Edge temp = new Edge(from, to, weight);
      edges.add(temp);
    }

    int s = scan.nextInt();
    Collections.sort(edges);

    kruskals();
    int cost = 0;
    for(Edge e:rem){
      cost = cost+e.weight;
    }
    System.out.println(cost);


  }

  public static void kruskals(){
    for(Edge e:edges){
      int frep = find(e.from);
      int trep = find(e.to);
      if(frep!=trep){
        union(trep,e.from);
        rem.add(e);
      }
      else{

      }
    }
  }

  public static int find(int u){
    int rep = unions.get(u);
    if(rep!=u){
      return find(rep);
    }
    else{
      return rep;
    }
  }

  public static void union(int t, int fr){
    unions.put(t,fr);
  }



}




class Edge implements Comparable<Edge>{
  int from;
  int to;
  int weight;

  public Edge(int from, int to, int weight){
    this.from = from;
    this.to = to;
    this.weight = weight;
  }

  public int compareTo(Edge that){
    return this.weight - that.weight;
  }



  public boolean equals(Object o){
    if(o instanceof Edge){
      Edge that = (Edge)o;
      return (this.from == that.from && this.to == that.to)||
              (this.from == that.to && this.to == that.from);
    }
    else{
      return false;
    }
  }

  public int hashCode(){
    return Objects.hash(this.from,this.to);
  }






}