public class Graph {
    Vertex[] vertexes;

}

enum State { Unvisited, Visited, Visiting; }
class Vertex{
    String name;
    State state;
    Vertex[] adjacents;
}
