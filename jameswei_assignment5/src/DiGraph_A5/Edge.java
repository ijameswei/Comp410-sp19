package DiGraph_A5;

public class Edge{
    public long id;
    public long weight;
    public String label;
    public Node start;
    public Node end;

    public Edge(long id, String label, Node start, Node end, long weight ){
        this.id = id;
        this.weight = weight;
        this.label = label;
        this.start = start;
        this.end = end;
    }
    public long getId(){
        return this.id;
    }
    public String getLabel(){
        return this.label;
    }
    public Node getStart(){
        return this.start;
    }
    public Node getEnd(){
        return this.end;
    }
    public long getWeight(){
        return this.weight;
    }

}
