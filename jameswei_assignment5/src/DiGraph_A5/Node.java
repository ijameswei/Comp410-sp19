package DiGraph_A5;

import java.util.HashMap;

public class Node {

    public long id;
    public String label;
    public long distance;
    public boolean visited;
    public HashMap<String, Edge> Inedge;
    public HashMap<String, Edge> Outedge;



    public Node(long id, String label){
        this.id = id;
        this.label = label;
        this.visited = false;
        distance = Long.MAX_VALUE;
        Inedge = new HashMap<>();
        Outedge = new HashMap<>();
    }

    public String getLabel(){
        return label;
    }

    public long getId(){
        return id;
    }
//
//    public long getInDegree(){
//        return inDegree;
//    }
//
//    public void changeInDegree(long num){
//        inDegree += num;
//    }
//
//    public Node copyNode(){
//        Node copy = this;
//        return copy;
//    }
}

