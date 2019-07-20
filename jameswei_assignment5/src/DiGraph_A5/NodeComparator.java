package DiGraph_A5;

import java.util.Comparator;

class NodeComparator implements Comparator<Node> {
    public int compare(Node v1, Node v2) {
        return (int) (v1.distance - v2.distance);
    }
}
