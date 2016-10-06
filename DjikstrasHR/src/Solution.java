/**
 * Created by David on 7/30/2016.
 */
import java.io.*;
import java.util.*;

public class Solution {

  public static HashMap<Integer,ArrayList<Edge>> outEdges = new HashMap<Integer,ArrayList<Edge>>();
  public static ArrayList<Vertex> vertices = new ArrayList<Vertex>();
  public static MyQueue dists = new MyQueue();
  public static int n;

  public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    Scanner scan = new Scanner(System.in);
    int t = scan.nextInt();

    while(t>0){
      outEdges = new HashMap<Integer,ArrayList<Edge>>();

      n = scan.nextInt();
      int m = scan.nextInt();
      for(int i = 1;i<=n;i++){
        outEdges.put(i,new ArrayList<Edge>());
        dists.add(i,10000);
      }

      for(int i = 0;i<m;i++){
        int from = scan.nextInt();
        int to = scan.nextInt();
        int weight = scan.nextInt();
        Edge temp = new Edge(from,to,weight);
        ArrayList<Edge> ftemps = outEdges.get(from);
        ArrayList<Edge> ttemps = outEdges.get(to);
        ftemps.add(temp);
        ttemps.add(temp);
        outEdges.put(from,ftemps);
        outEdges.put(to,ttemps);
      }

      int q = scan.nextInt();
      djikstras(q);

      for(int i = 1;i<n;i++){
        if(dists.getKey(i)!=10000){
          System.out.print(dists.getKey(i) + " ");
        }
        else{
          System.out.print(-1+ " ");
        }
      }

      if(dists.getKey(n)!=10000 && q!=n){
        System.out.print(dists.getKey(n));
      }
      else{
        System.out.print(-1);
      }

      System.out.println();
      t--;
    }
  }
  public static void djikstras(int from){
    initQ();
    dists.changeKey(from,0);
    ArrayList<Edge> neigh = outEdges.get(from);
    for(Edge e:neigh){
      int to = e.dest(from);
      dists.changeKey(to,e.weight);

    }
    int dist = 0;

    while(!dists.isEmpty()){
      int u = dists.extractMin();
      int uDist = dists.getKey(u);
      if(uDist == 10000){
        dist = uDist;
      }
      else {
        dist = dist + uDist;
      }
      ArrayList<Edge> neighs = outEdges.get(u);
      for(Edge e:neighs){
        int to = e.dest(u);
        int dis = dists.getKey(to);
        if(dis>dist+e.weight){
          dists.changeKey(to, dist+e.weight);
        }
      }
    }

  }



  public static void initQ(){
    dists = new MyQueue();
    for(int i = 1;i<=n;i++){
      dists.add(i,10000);
    }
  }
}




class MyQueue {
  ArrayList<Integer> queue;
  HashMap<Integer, Integer> keyMap;

  //constructor sets array list, and places sentinel placeholder node.
  public MyQueue(){
    this.queue = new ArrayList<Integer>();
    this.queue.add(-1); //Sentinel node.
    this.keyMap = new HashMap<Integer, Integer>();
  }

  //Add a node to the priority queue.
  //Adds given node to end of Q and upheaps.
  public void add(int given, int key){
    int index = this.queue.size();
    this.queue.add(given);
    this.keyMap.put(given, key);
    upHeap(index);
  }

  //Removes next item from the Q.
  //Replaces removed item with last item in Q and downheaps.
  public int extractMin() throws IndexOutOfBoundsException {
    if (this.queue.size()  > 1) {
      int min = this.queue.get(1);
      int max = this.queue.remove(this.queue.size() - 1);
      if (this.queue.size()  > 1) {this.queue.set(1, max);}
      downHeap(1);
      return min;
    }
    else{throw new IndexOutOfBoundsException("Queue is empty");}
  }

  //Performs upheap operation on given index.
  public void upHeap(int index) {
    if (index != 1) { //If item is at top of heap does nothing.
      int parentIndex = (int) Math.floor(index / 2); //Find index of parent node.
      int parentNode = this.queue.get(parentIndex); //get parent node.
      int thisNode = this.queue.get(index); //get this node.
      if (keyMap.get(thisNode)-keyMap.get(parentNode) < 0) { //compare parent/this. if this < parent swap and
        //upheap again on parentIndex.
        this.queue.set(parentIndex, thisNode);
        this.queue.set(index, parentNode);
        upHeap(parentIndex);
      }
    }
  }

  //Performs down heap operation.
  public void downHeap(int index) {
    int leftIndex = 2 * index; //Get left child
    int rightIndex = 2 * index + 1; //Get right child.
    if (leftIndex >= this.queue.size() || rightIndex >= this.queue.size()) {
      //If either child index is out of bounds stop, this is a child.
    }
    else {
      int smallerIndex; //Int to hold smaller index once found.
      int parentNode = this.queue.get(index); //Get this.
      int leftNode = this.queue.get(leftIndex); //Get left child
      int rightNode = this.queue.get(rightIndex); //Get right child.
      if (keyMap.get(parentNode)-keyMap.get(leftNode) > 0 || keyMap.get(parentNode)-keyMap.get(rightNode) > 0) {
        //If this is greater than either child....
        if (keyMap.get(leftNode)-keyMap.get(rightNode) < 0) { //Find smaller of children.
          smallerIndex = leftIndex;
        } else {
          smallerIndex = rightIndex;
        }
        int smallerNode = this.queue.get(smallerIndex);
        this.queue.set(index, smallerNode);
        this.queue.set(smallerIndex, parentNode); //Swap with smaller child.
        downHeap(smallerIndex); //Down heap on smaller index.
      }
    }
  }

  public int getKey(int i){
    return keyMap.get(i);
  }

  //Changes a nodes key with given key.
  public void changeKey(int given, int newKey){
    int mod = keyMap.get(given);
    if(newKey < mod){ //If key is smaller than do this, else do nothing.
      keyMap.put(given,newKey); //Change the key
      int index = this.queue.indexOf(mod);
      if(index > 0){upHeap(index);} //Upheap based on new key.
    }
  }

  //Returns true of queue only holds sentinel.
  public boolean isEmpty(){
    return this.queue.size() == 1;
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

  public int dest(int from){
    if(from == this.from){
      return this.to;
    }
    else{
      return this.from;
    }
  }

  public int compareTo(Edge that){
    return this.weight - that.weight;
  }

  public boolean equals(Object o){
    if(o instanceof Edge){
      Edge that = (Edge)o;
      return this.from == that.from && this.to == that.to;
    }
    else{
      return false;
    }
  }

  public int hashCode(){
    return Objects.hash(this.from,this.to);
  }
}

class Vertex implements Comparable<Vertex>{
  int from;
  int dist;

  public Vertex(int from, int dist){
    this.from = from;
    this.dist = dist;
  }

  public int compareTo(Vertex that){
    return this.dist - that.dist;
  }

  public boolean equals(Object o){
    if(o instanceof Vertex){
      Vertex that = (Vertex)o;
      return this.from == that.from;
    }
    else{
      return false;
    }
  }

  public void updateDist(int given){
    this.dist = given;
  }


  public int hashCode(){
    return Objects.hash(this.from);
  }
}