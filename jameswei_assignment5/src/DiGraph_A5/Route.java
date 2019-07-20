package DiGraph_A5;


//unused.. give up this method
public class Route implements Comparable<Route> {

    private long length;
    private Node dist;

    public Route(long length, Node dist) {
        this.length=length;
        this.dist=dist;
    }

    public long getlength() {
        return length;
    }

    public Node getdist() {
        return dist;
    }

    @Override
    public int compareTo(Route R) {
        return ((Long)(this.getlength())).compareTo(R.getlength());
    }

}
