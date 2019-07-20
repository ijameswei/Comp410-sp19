package MinBinHeap_A3;

import java.nio.BufferUnderflowException;

public class MinBinHeap implements Heap_Interface{

    private EntryPair[] array;
    private int size;
    private static final int arraySize = 10000;

    public MinBinHeap(){
        this.array = new EntryPair[arraySize];
        array[0]  = new EntryPair(null,-10000);
    }

    @Override
    public void insert(EntryPair entry) {
        if(size == 0){
            array[1] = entry;
        }

        int hole = size + 1;
        array[hole] = entry;

        while(hole > 1){
            if(array[hole].priority < array[hole/2].priority){

            }else{
                break;
            }
        }
        size += 1;
    }

    @Override
    public void delMin() {
        if(size == 0){
            throw new BufferUnderflowException();
        }
        array[1] = array[size--];
        percolateDown(1);

    }

    @Override
    public EntryPair getMin() {
        if(size() == 0){
            return null;
        }
        return array[1];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void build(EntryPair[] entries) {
        size =entries.length;
        for (int i = 0; i < size; i ++){
            array[i+1] = entries[i];
        }
        for (int i = size/2; i > 0; i--){
            percolateDown(i);
        }

    }

    @Override
    public EntryPair[] getHeap() {
        return new EntryPair[0];
    }

    public static void swap(EntryPair[] array, int a, int b){
        EntryPair temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
    private void percolateDown(int hole){
        int child;
        EntryPair temp = array[hole];
        while(hole * 2 <= size){
            child = hole * 2;
            if(child != size && array[child+1].getPriority()< array[child].getPriority()){
                child++;
            }

            if(array[child].getPriority() < temp.getPriority()){
                array[hole] = array[child];
            }else{
                break;
            }
            hole = child;
        }
        array[hole] = temp;
    }

}