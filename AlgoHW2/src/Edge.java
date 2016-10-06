/**
 * Created by David on 5/22/2016.
 */

//Class to represent a graph edge.
public class Edge implements Comparable<Edge> {
  Vertex from;
  Vertex to;
  int weight;

  public Edge(Vertex from, Vertex to, int weight) {
    this.from = from;
    this.to = to;
    this.weight = weight;
  }

  //Returns true if this edge equals given object.
  //edge (v1, v2), (v2, v1) will return true.
  public boolean equals(Object given) {
    if (given instanceof Edge) {
      Edge that = (Edge) given;
      return this.from.equals(that.from)
              && this.to.equals(that.to) ||
              this.from.equals(that.to)
                      && this.to.equals(that.from);

    } else {
      return false;
    }
  }

  //Returns a strign representation of this edge.
  public String toString() {
    return this.from.toString() + "," + this.to.toString() + "=" + this.weight;
  }

  //Compares this edge to given edge, by weight.
  public int compareTo(Edge given) {
    return this.weight - given.weight;
  }

  //Returns where this edge leads to in respect to the given vertex.
  public String goesTo(Vertex given) {
    if (given.equals(this.to)) {
      return this.from.toString();
    } else {
      return this.to.toString();
    }
  }

  //Overridden hascode, ensures placement of vertices will not affect equality.
  public int hashCode(){
    return from.hashCode() ^ to.hashCode();
  }
}



