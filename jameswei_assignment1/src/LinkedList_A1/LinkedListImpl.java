package LinkedList_A1;

public class LinkedListImpl implements LIST_Interface{
    Node sentinel;
    int count = 0;
    public LinkedListImpl(){
        sentinel = new Node(0);
    }

    public Node getRoot(){
        return sentinel;
    }

    @Override
    public boolean insert(double elt, int index) {
        if(index < 0 || index > size()){
            return false;
        }
        Node insert = new Node(0);
        Node current = sentinel;

        for(int i = 0; i <= index ; i++){
            current.next = current;
        }
        insert.next = current;
        insert.prev = current.prev;
        current.prev.next = insert;
        current.prev = insert;
        count ++;

        return true;
    }

    @Override
    public boolean remove(int index) {
        if(index < 0 || index > size()){
            return false;
        }
        Node current = sentinel;
        for(int i = 0; i <= index; i++){
            current.next = current;
        }
        current.prev.next = current.next;
        current.next.prev = current.prev;
        return true;
    }

    @Override
    public double get(int index) {
        if(index < 0 || index > size()){
            return Double.NaN;
        }
        Node current = sentinel;
        for(int i = 0; i <= index; i++){
            current.next = current;
        }
        return current.data;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public boolean isEmpty() {
        if(size() == 0){
            return true;
        }return false;
    }

    @Override
    public void clear() {
        sentinel.prev = null;
        sentinel.next = null;
    }


}