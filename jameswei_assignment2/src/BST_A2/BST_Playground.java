package BST_A2;

public class BST_Playground{
    public static void main(String[] args){
        //
    }


    static void prinLevelOrder(BST tree){
        int h = tree.getRoot().getHeight(tree.getRoot());
        for(int i = 0; i <= h; i++){
            printGivenLevel(tree.getRoot(),i);
        }
    }


    static void printGivenLevel(BST_Node root, int level){
        if(root == null){
            return;
        }
        if(level == 0){
            System.out.println(root.data + " ");
        }else if(level > 0){
            printGivenLevel(root.left, level-1);
            printGivenLevel(root.right,level-1);
        }
    }


    static void printInOrder(BST_Node root){
        if(root!= null){
            printInOrder(root.getLeft());
            System.out.println(root.getData()+" ");
            printInOrder(root.getRight());
        }
    }
    public static void ContainsTest0(){
        BST tree = new BST();
        //insert("B"), insert("A"), insert("D"), insert("C"), insert("E"), contains("D")
        tree.insert("B");
        tree.insert("A");
        tree.insert("D");
        tree.insert("C");
        tree.insert("E");
        tree.contains("D");

        System.out.println(tree);

    }
}