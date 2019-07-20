package BST_A2;

public class BST implements BST_Interface{
    public BST_Node root;
    int size;
    public BST(){
        size = 0;
        root = null;
    }

    @Override
    public boolean insert(String s) {
        if(contains(s)){
            return false;
        }
        if(this.getRoot() == null){
            root = new BST_Node(s);
            size++;return true;
        }
        if(this.getRoot().insertNode(s) == true){
            size ++;
            return true;
        }
        return false;
    }

    @Override
    public boolean remove(String s) {
        if(size() == 0){
            return false;
        }
        if(contains(s)){
            this.root = this.getRoot().removeNode(root,s);
            size--;
            return true;
        }else {
            return false;
        }
    }

    @Override
    public String findMin() {
        if(size==0){
            return null;
        }return root.findMin(root).getData();
    }

    @Override
    public String findMax() {
        if(size == 0){
            return null;
        }return root.findMax(root).getData();
    }

    @Override
    public boolean empty() {
        if(size() == 0){
            return true;
        }return false;
    }

    @Override
    public boolean contains(String s) {
        if(size() == 0){
            return false;
        }
        if(root.containsNode(s)){
            return true;
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int height() {
        if(size == 0){
            return -1;
        }return this.getRoot().getHeight(root)-1;
    }

    @Override
    public BST_Node getRoot() {
        return root;
    }
}