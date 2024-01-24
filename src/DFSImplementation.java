public class DFSImplementation {


    public static void main(String[] args) {

    }

    static void dfsRecursive(Graph graph, Vertex start){
        if(graph.vertexes==null)return;

        start.state=State.Visited;
        System.out.println(start.name);
        for(Vertex v:start.adjacents){
            if(v.state==State.Unvisited){
                dfsRecursive(graph,v);
            }

        }

    }
}
