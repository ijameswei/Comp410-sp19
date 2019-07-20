package BST_A2;

public class BST_Node{
    String data;
    BST_Node left;
    BST_Node right;
    BST_Node(String data){
        this.data = data;
    }

    public String getData(){return data;}
    public BST_Node getLeft(){
        return left;
    }
    public BST_Node getRight(){
        return right;
    }

    public boolean containsNode(String s){
        if(s == null){
            return false;
        }
        int compareResult = this.data.compareTo(s);
        if(compareResult< 0){
            if(this.right == null){
                return false;
            }return this.right.containsNode(s);
        }else if(compareResult > 0){
            if(this.left == null){
                return false;
            }return this.left.containsNode(s);
        }else{
            return true;
        }
    }

    public boolean insertNode(String s){
        if(s == null){
            return false;
        }
        int compareResult = this.data.compareTo(s);
        if(compareResult < 0){
            if(this.right == null){
                this.right = new BST_Node(s);
                return true;
            }else{
                return this.right.insertNode(s);
            }
        }else if (compareResult>0){
            if(this.left == null){
                this.left = new BST_Node(s);
                return true;
            }else{
                return this.left.insertNode(s);
            }
        }
        return false;
    }
    public BST_Node removeNode(BST_Node root, String s){
        if(root == null){
            return root;
        }
        int compareResult = root.data.compareTo(s);

        if(compareResult < 0){
            root.right = removeNode(root.right,s);
        }else if(compareResult > 0){
            root.left = removeNode(root.left,s);
        }else{
            if(root.left == null){
                return root.right;
            }else if(root.right == null){
                return root.left;
            }else{
                BST_Node node = findMin(root.right);
                root.data = node.data;
                root.right = removeNode(root.right,node.data);
            }
        }
        return root;
    }

    public BST_Node findMin(BST_Node min){
        if(min == null){
            return null;
        }else if (min.left == null){
            return min;
        }else{
            return findMin(min.left);
        }
    }
    public BST_Node findMax(BST_Node max){
        if(max == null){
            return null;
        }else if(max.right == null){
            return max;
        }else{
            return findMax(max.right);
        }
    }

    public int getHeight(BST_Node root){
        if(root == null){
            return 0;
        }
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        return Math.max(leftHeight,rightHeight)+1;
    }

    public String toString(){
        return "Data: "+this.data+", Left: "+((this.left!=null)?left.data:"null")
                +",Right: "+((this.right!=null)?right.data:"null");
    }


}






























