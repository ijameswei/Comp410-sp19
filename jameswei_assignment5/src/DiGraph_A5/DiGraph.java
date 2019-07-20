package DiGraph_A5;


import java.util.*;
import java.util.Map.Entry;

public class DiGraph implements DiGraphInterface {
    int numEdge = 0;
    int numNode = 0;

    private HashMap<String, Node> str_vertex;
    private HashSet<Long> id_edge;
    private HashSet<Long> id_vertex;
    private Map<String,LinkedList<Edge>> vertices = new HashMap<String,LinkedList<Edge>>();


    // in here go all your data and methods for the graph

 public DiGraph ( ) {// default constructor
//        // explicitly include this
//        // we need to have the default constructor
//        // if you then write others, this one will still be there

        this.str_vertex = new HashMap<String, Node>();
        this.id_edge = new HashSet<Long>();
        this.id_vertex = new HashSet<Long>();
 }



    @Override
    public boolean addNode(long idNum, String label) {
//        addNode
//        in: unique id number of the node (0 or greater)
//        string for name
//        you might want to generate the unique number automatically
//        but this operation allows you to specify any integer
//        both id number and label must be unique
//        return: boolean
//        returns false if node number is not unique, or less than 0
//        returns false if label is not unique (or is null)
//        returns true if node is successfully added


        if ( (idNum < 0) ||(label == null)){
            return false;
        }
        if(id_vertex.contains(idNum)){
            return false;
        }

        //add node
        Node temp = new Node(idNum,label);

        if(str_vertex.get(label)!= null){
            return false;
        }
        str_vertex.put(label,temp);
        id_vertex.add(idNum);

        numNode++;

        return true;

    }


    @Override
    public long numNodes() {
        return  numNode;
    }

    @Override
    public long numEdges() {
        return numEdge;
    }
    public boolean addEdge(long idNum, String sLabel, String dLabel, long weight, String eLabel) {
        if ( idNum < 0 ||sLabel==null||dLabel==null) {
            return false;
        }
        if (id_edge.contains(idNum)) {
            return false;
        }
        Node source = str_vertex.get(sLabel);
        Node destination = str_vertex.get(dLabel);
        Edge e = new Edge(idNum,eLabel,source,destination,weight);
             //   (idNum, weight, eLabel, destination, source);
        if (source == null) {
            return false;
        }
        if (destination == null) {
            return false;
        }
        if (source.Outedge.put(dLabel, e) != null) {
            return false;
        }
        destination.Inedge.put(sLabel, e);

        id_edge.add(idNum);
        numEdge++;
        return true;
    }

    @Override
    public boolean delNode(String label) {
//        delNode
//        in: string
//        label for the node to remove
//        out: boolean
//        return false if the node does not exist
//        return true if the node is found and successfully removed

        if(!str_vertex.containsKey(label)){
            return false;
        }
        Node delnode = str_vertex.get(label);

        str_vertex.remove(label);
        id_vertex.remove(delnode.id);
        for(Edge e :delnode.Outedge.values()){
            id_edge.remove(e.id);
            e.end.Inedge.remove(label);
        }
        for(Edge e:delnode.Inedge.values()){
            id_edge.remove(e.id);
            e.start.Outedge.remove(label);
        }
        numNode--;
        return true;

    }

    @Override
    public boolean delEdge(String sLabel, String dLabel) {
//        delEdge
//        in: string label for source node
//        string label for destination node
//        out: boolean
//        return false if the edge does not exist
//        return true if the edge is found and successfully removed


        Node source = str_vertex.get(sLabel);
        if (source == null) {
            return false;
        } else {
            Edge e = source.Outedge.get(dLabel);
            if (e == null) {
                return false;
            } else {
                this.id_edge.remove(e.id);
                e.end.Inedge.remove(sLabel);
                source.Outedge.remove(dLabel);
                numEdge--;
                return true;

            }
        }
    }


//
//    class NodeComparator implements Comparator<Node> {
//        public int compare(Node v1, Node v2) {
//            return (int) (v1.distance - v2.distance);
//        }
//    }


    public ShortestPathInfo[] shortestPath(String label) {

        PriorityQueue<Node> unvisited = new PriorityQueue<>(new NodeComparator());
        //start
        Node start = str_vertex.get(label);
        start.distance = 0;
        unvisited.add(start);

        // closest unvisited Node
        while (unvisited.isEmpty() == false) {
            Node current = unvisited.poll();
            current.visited = true;

            // visit each Node adjacent to current
            for (Edge e : current.Outedge.values()) {
                Node adjacent = e.end;

                if (!adjacent.visited) {
                    long weight = e.weight;

                    if (current.distance + weight < adjacent.distance) {
                        adjacent.distance = current.distance + weight;
                        unvisited.add(adjacent);
                    }
                }
            }
        }
        // return  array
        ArrayList<ShortestPathInfo> paths = new ArrayList<>();
        for (Node v : str_vertex.values()) {
            if (v.distance == Long.MAX_VALUE) {
                v.distance = -1;
            }
            ShortestPathInfo path = new ShortestPathInfo(v.label, v.distance);
            paths.add(path);
        }
        return paths.toArray(new ShortestPathInfo[str_vertex.size()]);
    }




}
