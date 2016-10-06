import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by David on 5/23/2016.
 */

//Class to represent a priority queue
public class PriorityQueue {
  ArrayList<Node> queue;
  HashMap<String, Node> keyMap;

  //constructor sets array list, and places sentinel placeholder node.
  public PriorityQueue(){
    this.queue = new ArrayList<Node>();
    this.queue.add(new Node(null, null, -1)); //Sentinel node.
    this.keyMap = new HashMap<String, Node>();
     }

  //Add a node to the priority queue.
  //Adds given node to end of Q and upheaps.
  public void add(Node given){
    int index = this.queue.size();
    this.queue.add(given);
    this.keyMap.put(given.toString(), given);
    upHeap(index);
  }

  //Removes next item from the Q.
  //Replaces removed item with last item in Q and downheaps.
  public Node extractMin() throws IndexOutOfBoundsException {
    if (this.queue.size()  > 1) {
      Node min = this.queue.get(1);
      Node max = this.queue.remove(this.queue.size() - 1);
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
      Node parentNode = this.queue.get(parentIndex); //get parent node.
      Node thisNode = this.queue.get(index); //get this node.
      if (thisNode.compareKeys(parentNode) < 0) { //compare parent/this. if this < parent swap and
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
        Node parentNode = this.queue.get(index); //Get this.
        Node leftNode = this.queue.get(leftIndex); //Get left child
        Node rightNode = this.queue.get(rightIndex); //Get right child.
        if (parentNode.compareKeys(leftNode) > 0 || parentNode.compareKeys(rightNode) > 0) {
          //If this is greater than either child....
          if (leftNode.compareKeys(rightNode) < 0) { //Find smaller of children.
            smallerIndex = leftIndex;
          } else {
            smallerIndex = rightIndex;
          }
          Node smallerNode = this.queue.get(smallerIndex);
          this.queue.set(index, smallerNode);
          this.queue.set(smallerIndex, parentNode); //Swap with smaller child.
          downHeap(smallerIndex); //Down heap on smaller index.
        }
      }
    }

  //Changes a nodes key with given key.
  public void changeKey(String given, int newKey){
    Node mod = keyMap.get(given);
    if(newKey < mod.getKey()){ //If key is smaller than do this, else do nothing.
      mod.changeKey(newKey); //Change the key
      int index = this.queue.indexOf(mod);
      if(index > 0){upHeap(index);} //Upheap based on new key.
    }
  }

  //Returns true of queue only holds sentinel.
  public boolean isEmpty(){
    return this.queue.size() == 1;
  }

}
