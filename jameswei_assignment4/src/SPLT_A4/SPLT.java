package SPLT_A4;

public class SPLT implements SPLT_Interface{
    private BST_Node root;
    private int size;

    public SPLT() {
        this.size = 0;
    }

    public void insert(String s){
    if (root == null){
        root = new BST_Node(s);
        size++;
        return;
    }
    root = root.insertNode(s, root);
    if (root.justMade == true){
        size++;
        return;
    } else {
        return;
    }
}
    @Override
    public void remove(String s) {
        if(s == null || root == null || !contains(s)){
            return;
        }
        //if root has no left child
        if (root.left == null) {
            root = root.right;

        } else {
            BST_Node right_node = root.right;
            if (right_node == null) {
                root = root.left;
            } else {
                root = root.left.findMax();
            }
            if (right_node != null) {
                root.right = right_node;
            }
            if (root.right != null) {
                root.right.parent = root;
            }
        }
        if (root != null) {
            root.parent = null;
        }
        size = size - 1;
    }

    @Override
    public String findMin() {
        if(empty()){
            return null;
        }
        else{
            root = root.findMin();
            return root.data;
        }
    }

    @Override
    public String findMax() {
        if(empty()){
            return null;
        }else{
            root = root.findMax();
            return root.data;
        }
    }
    @Override
    public boolean empty() {
        if(size == 0){
            return true;
        }return false;
    }
    @Override
    public boolean contains(String s) {
        if (empty()) {
            return false;
        }
        root = root.containsNode(s);
        Boolean flag = root.data.equals(s);
        return flag;
    }
    @Override
    public int size() {
        return size;
    }
    @Override
    public int height() {
        if(empty()){
            return -1;
        }
        return root.getHeight();
    }
    public BST_Node getRoot() { //please keep this in here! I need your root node to test your tree!
        return root;
    }

}

