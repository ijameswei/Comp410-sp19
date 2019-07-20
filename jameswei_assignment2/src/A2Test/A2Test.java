package A2Test;
import org.junit.Test;
import org.junit.Assert;
import BST_A2.*;
public class A2Test {
    private BST bushy = new BST();
    private BST list = new BST();
    @Test
    public void test1(){
        Assert.assertEquals(bushy.getRoot(), null);
        Assert.assertEquals(list.getRoot(), null);
        Assert.assertEquals(bushy.size(), 0);
        Assert.assertEquals(bushy.height(), -1);
    }

    @Test
    public void test2(){
        Assert.assertTrue(bushy.insert("E"));
        bushy.insert("B");
        bushy.insert("D");
        Assert.assertFalse(bushy.insert("E"));
        bushy.insert("C");
        bushy.insert("F");
        bushy.insert("A");
        Assert.assertEquals(bushy.size(), 6);
        Assert.assertEquals(bushy.height(), 3);
        Assert.assertTrue(bushy.contains("B"));
        Assert.assertTrue(bushy.findMax().equals("F"));
        Assert.assertTrue(bushy.findMin().equals("A"));
        Assert.assertTrue(bushy.getRoot().getLeft().getLeft().getData().equals("A"));
        Assert.assertTrue(bushy.contains("D"));

    }

    private void initializeBushy(){
        bushy.insert("E");
        bushy.insert("B");
        bushy.insert("D");
        bushy.insert("C");
        bushy.insert("F");
        bushy.insert("A");
    }

    private void initializeList(){
        list.insert("A");
        list.insert("B");
        list.insert("C");
        list.insert("D");
        list.insert("E");
        list.insert("F");
    }

    @Test
    public void test3(){
        initializeBushy();
        Assert.assertTrue(bushy.remove("D"));
        Assert.assertTrue(bushy.getRoot().getLeft().getRight().getData().equals("C"));
        Assert.assertEquals(bushy.size(), 5);
        Assert.assertEquals(bushy.height(), 2);
    }

    @Test
    public void test4(){
        initializeBushy();
        Assert.assertTrue(bushy.remove("E"));
        Assert.assertTrue(bushy.getRoot().getData().equals("D"));
//        printLevelOrder(bushy);
    }

    @Test
    public void test5(){
        initializeList();
        Assert.assertEquals(list.size(), 6);
        Assert.assertEquals(list.height(), 5);
    }

    @Test
    public void test6(){
        initializeList();
        Assert.assertTrue(list.remove("D"));
//        printLevelOrder(list);
    }

    @Test
    public void test7(){
        initializeList();
        Assert.assertTrue(list.remove("A"));
//        printLevelOrder(list);
        Assert.assertTrue(list.getRoot().getData().equals("B"));
    }

//    static void printLevelOrder(BST tree){
//        //will print your current tree in Level-Order...
//        //https://en.wikipedia.org/wiki/Tree_traversal
//
//        int h=tree.getRoot().getHeight();
//        for(int i=0;i<=h;i++){
//            printGivenLevel(tree.getRoot(), i);
//        }
//
//    }
    static void printGivenLevel(BST_Node root,int level){
        if(root==null)return;
        if(level==0)System.out.print(root.getData()+" ");
        else if(level>0){
            printGivenLevel(root.getLeft(),level-1);
            printGivenLevel(root.getRight(),level-1);
        }
    }
    static void printInOrder(BST_Node root){
        //will print your current tree In-Order
        if(root!=null){
            printInOrder(root.getLeft());
            System.out.print(root.getData() + " ");
            printInOrder(root.getRight());
        }
    }
}
