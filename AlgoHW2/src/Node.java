/**
 * Created by David on 5/24/2016.
 */

//container class for priority queue.
public class Node implements Comparable<Node>{
  Vertex vertex; //Stores this vertex.
  Vertex previous; //Stores came from Vertex.
  int key; //Key value.

  public Node(Vertex vertex, Vertex previous,  int key){
    this.vertex = vertex;
    this.previous = previous;
    this.key = key;
  }
  public void changeKey(int given){
    this.key = given;
  }

  //Returns this key.
  public int getKey(){
    return this.key;
  }

  //Compares two nodes, lexicographically by vertex.
  public int compareTo(Node given){
    return this.vertex.toString().compareTo(given.vertex.toString());
  }




  //compares to nodes key values.
  public int compareKeys(Node given){
    return this.key - given.key;
  }

  //String representation of stored vertex.
  public String toString(){
    return this.vertex.toString();
  }

  //Prints this node.
  public String printNode(){
    if(this.key == Integer.MAX_VALUE){return this.vertex.toString() + "=" + "INF";}
    else {
      return this.vertex.toString() + "=" + this.key;
    }
  }

  //Sets this.previous
  public void setPrevious(Vertex given){
    this.previous = given;
  }
}