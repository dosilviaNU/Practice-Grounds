import java.util.ArrayList;
import java.util.HashMap;

import static java.lang.Integer.valueOf;

/**
 * Created by David on 5/22/2016.
 */
//Class to store graph representation.
public class Graph {
  public HashMap<String, ArrayList<Edge>> adjacencyMap;
  public ArrayList<Edge> knownEdges;
  public ArrayList<Vertex> vertices;


  //Constructor for graph, takes a text graph representation.
  public Graph(ArrayList<String> textGraph) {
    this.adjacencyMap = new HashMap<String, ArrayList<Edge>>();
    this.vertices = new ArrayList<Vertex>();
    //Add all vertices to graph, V0-V9
    for (int i = 0; i < 10; i++) {
      this.adjacencyMap.put("V" + i, new ArrayList<Edge>());
      this.vertices.add(new Vertex("V" + i));
    }
    knownEdges = new ArrayList<Edge>();
    buildNetworkGraph(textGraph);
  }


  //Parse next update edge.
  public Edge nextUpdateEdge(String update){
    String[] vertexStatus = update.split("=");
    String[] vertices = vertexStatus[0].split(",");
    Vertex from = new Vertex(vertices[0]);
    Vertex to = new Vertex(vertices[1]);
    Edge updateEdge = new Edge(from, to, 0);
    return updateEdge;
  }

  //Parse next graph update.
  public void updateGraph(String update) {
    String[] vertexStatus = update.split("=");
    String[] vertices = vertexStatus[0].split(",");
    Vertex from = new Vertex(vertices[0]);
    Vertex to = new Vertex(vertices[1]);
    String status = vertexStatus[1];
    Edge updateEdge = new Edge(from, to, 0);
    int index = knownEdges.indexOf(new Edge(from, to, 0));
    Edge known = knownEdges.get(index);
    if (status.equals("U")) { //If edge is up add it to relevant vertices.
      adjacencyMap.get(from.toString()).add(new Edge(from, to, known.weight));
      adjacencyMap.get(to.toString()).add(new Edge(from, to, known.weight));
    }
    else if (status.equals("D")) { //If edge is down, remove it from relevant vertices.
      adjacencyMap.get(from.toString()).remove(new Edge(from, to, known.weight));
      int array = adjacencyMap.get(to.toString()).size();
      adjacencyMap.get(to.toString()).remove(new Edge(from, to, known.weight));
    }
  }

  //Builds the graph representation as an adjacency list. Vertices map to list of edges.
  private void buildNetworkGraph(ArrayList<String> networkGraph){
    for(String edge:networkGraph){
      String[] vertexWeight = edge.split("=");
      String[] vertices = vertexWeight[0].split(",");
      Vertex from = new Vertex(vertices[0]);
      Vertex to = new Vertex(vertices[1]);
      int weight = Integer.valueOf(vertexWeight[1]);
      adjacencyMap.get(from.toString()).add(new Edge(from, to, weight));
      adjacencyMap.get(to.toString()).add(new Edge(from, to, weight));
      knownEdges.add(new Edge(from, to, weight));
    }
  }
}
