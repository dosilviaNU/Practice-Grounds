/**
 * Created by David on 5/22/2016.
 */
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

//Class that performs Dijkstras algorithm to find the shortest distance from a
//vertices to all other vertices in a graph.
public class Djikstra {
    public static Graph graph;
    public static ArrayList<String> networkGraph;
    public static ArrayList<String> graphUpdates;
    private static PriorityQueue priorityQ;
    private static ArrayList<Node> paths;
    private static ArrayList<Edge> edges;

    public static void main(String[] args) {
      if (args.length < 1) System.exit(0);
      Scanner scan = new Scanner(System.in);

      scan.nextInt();


      intepretGraph(args); //Decipher the given graph.
      intepretGraphUpdates(args); //Decipher the given graph updates.
      setGraph(); //Build the graph representation.
      setQueue(); //Build the priority queue.
      dijkstrasAlgo(); //Find the best paths distances.
      buildEdges(); //Build the set of edges for optimal path.
      Collections.sort(paths); //Sort the paths.
      for (int i = 0; i < paths.size(); i++) { //Prints the initial distances.
        if (i == paths.size() - 1) {
          System.out.print(paths.get(i).printNode());
        } else {
          System.out.print(paths.get(i).printNode() + ",");
        }
      }
      System.out.println();
      for (int i = 0; i < graphUpdates.size(); i++) { //Prints the distances after each update.
        Edge next = graph.nextUpdateEdge(graphUpdates.get(i));

        /**
         * The instance in which you would not need to recompute the algorithm is if the given
         * update is not one of the edges that the path uses to navigate the shortest distances,
         * I check for this by creating a list of edges that the optimal paths use,
         * and then I check wheter the given update edge is a member of this list,
         * if not nothing happens.
         */



        if (edges.contains(next)) { //Determines whether update edge affects the current path.
          graph.updateGraph(graphUpdates.get(i));
          setQueue();
          dijkstrasAlgo();}
        Collections.sort(paths);
          for (int j = 0; j < paths.size(); j++) { //Print paths after each update.
            if (j == paths.size() - 1) {
              System.out.print(paths.get(j).printNode());
            } else {
              System.out.print(paths.get(j).printNode() + ",");
            }
          }
          System.out.println();
        }

      }



  //Sets the priority queue.
  private static void setQueue() {
    priorityQ = new PriorityQueue();
    for (int i = 0; i < 10; i++) {
      if (i == 0) {
        priorityQ.add(new Node(new Vertex("V" + i), null, 0)); //Sets VO to 0.
      } else {

        priorityQ.add(new Node(new Vertex("V" + i), null, Integer.MAX_VALUE)); //Sets all other
        //vertices to max integer value.
      }
    }
  }

  //Builds the graph representation.
  private static void setGraph(){
    graph = new Graph(networkGraph);
  }

  //Interpets the text file graph.
  private static void intepretGraph(String[] args){
    networkGraph = new ArrayList<String>();
    try {
      BufferedReader reader =
              new BufferedReader(new FileReader(args[0]));
      String line;
      while ((line = reader.readLine()) != null) {
        networkGraph.add(line);
      }
      reader.close();
    } catch (Exception e) {
      System.err.println("Couldn't read " + args[0]);
    }
  }

  //Inteprets the graph updates text file.
  private static void intepretGraphUpdates(String[] args){
    graphUpdates = new ArrayList<String>();

    try {
      BufferedReader reader =
              new BufferedReader(new FileReader(args[1]));
      String line;
      while ((line = reader.readLine()) != null) {
        graphUpdates.add(line);
      }
      reader.close();
    } catch (Exception e) {
      System.err.println("Couldn't read " + args[1]);
    }
  }

  //Performs Dijkstras Algorithm.
  private static void dijkstrasAlgo(){
    Node start = priorityQ.extractMin(); //Extract starting node.
    paths = new ArrayList<Node>(); //Build arraylist to store visited nodes.
    paths.add(start); //Add start node to list of visited node.
     int nodeDist = 0; //Integer to represent last shortest distance to source.
    ArrayList<Edge> neighbors = graph.adjacencyMap.get(start.toString()); //Build list of
    //start nodes neighbors.
    for(Edge e:neighbors){ //For each neighbor of V0 changeKey(their dist to V0)
      priorityQ.changeKey(e.goesTo(start.vertex), e.weight);
      Node neighbor = priorityQ.keyMap.get(e.goesTo(start.vertex));
      neighbor.setPrevious(start.vertex);
    }

    while(!priorityQ.isEmpty()){ //While the priority Q isn't empty.
      Node next = priorityQ.extractMin(); //Get next closest node.
      paths.add(next); //Add this node to set of visited nodes.
      neighbors = graph.adjacencyMap.get(next.vertex.toString()); //Get next nodes neighbors.
      for(Edge e:neighbors){ //For each neighbor of next, if their current dist to A
        //is greater than dist + weight(next -> neighbor),
        // perform changeKey(dist + weight(next->neightbor)
        nodeDist = e.weight + next.getKey(); //Update last shortest distance.
        Node neighbor = priorityQ.keyMap.get(e.goesTo(next.vertex));
        if(neighbor.getKey() > nodeDist) {
          priorityQ.changeKey(e.goesTo(next.vertex), nodeDist); //changeKey
          neighbor.setPrevious(next.vertex); //set previous vertex.
        }
      }

    }
  }

  //Builds the list of edges paths takes.
  private static void buildEdges(){
    edges = new ArrayList<Edge>();
    for(Node node:paths){
      edges.add(new Edge(node.previous, node.vertex, node.key));
    }

  }





}























