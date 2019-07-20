package LinkedList_A1;

public class LinkedListPlayground{
    public static void main(String[] args){
        test1();
        test2();
        GetTest();
    }


    public static void test1(){
        LinkedListImpl L = new LinkedListImpl();
        System.out.println(L.isEmpty());
        printList(L);
        L.clear();
        System.out.println(L.isEmpty());

        printList(L);
        System.out.println(L.sentinel.toString());
        L.insert(3.3,0);
        System.out.println(L.isEmpty());

        printList(L);
        System.out.println(L.sentinel.next.toString());
        L.insert(3.4,0);

    }


    public static void printList(LinkedListImpl L){
        Node curr = L.sentinel.next;
        System.out.print("sentinel");
        for(int i = 0; i < L.size(); i++){
            System.out.print(" --> " + curr.data);
            curr = curr.next;
        }
        System.out.println();
    }

    public static void GetTest1(){
        LinkedListImpl L = new LinkedListImpl();
        System.out.println(L.get(0));
    }
}