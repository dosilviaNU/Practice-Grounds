import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by David on 5/23/2016.
 */

//Class to represent a vertex.
public class Vertex {
  String name;
 public Vertex(String name){
    this.name = name;
  }
 public String toString(){
    return this.name;
  }

  //Returns true if this vertex is equal to given object.
  public boolean equals(Object o){
    if(o instanceof Vertex){
      Vertex that = (Vertex)o;
      return that.name.equals(this.name);
    }
    else{return false;}
  }

public int hashCode(){
  return Objects.hash(this.name);
}

}
