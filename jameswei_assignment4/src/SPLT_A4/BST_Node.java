package SPLT_A4;

public class BST_Node {
    String data;
    BST_Node left;
    BST_Node right;
    BST_Node parent; //parent...not necessarily required, but can be useful in splay tree
    boolean justMade; //could be helpful if you change some of the return types on your BST_Node insert.
    //I personally use it to indicate to my SPLT insert whether or not we increment size.

    BST_Node(String data) {
        this.data = data;
        this.justMade = true;
    }

    BST_Node(String data, BST_Node left, BST_Node right, BST_Node parent) { //feel free to modify this constructor to suit your needs
        this.data = data;
        this.left = left;
        this.right = right;
        this.parent = parent;
        this.justMade = true;
    }

    // --- used for testing  ----------------------------------------------
    //
    // leave these 3 methods in, as is (meaning also make sure they do in fact return data,left,right respectively)

    public String getData() {
        return data;
    }

    public BST_Node getLeft() {
        return left;
    }

    public BST_Node getRight() {
        return right;
    }

    // --- end used for testing -------------------------------------------


    // --- Some example methods that could be helpful ------------------------------------------
    //
    // add the meat of correct implementation logic to them if you wish

    // you MAY change the signatures if you wish...names too (we will not grade on delegation for this assignment)
    // make them take more or different parameters
    // have them return different types
    //
    // you may use recursive or iterative implementations

  /*
  public BST_Node containsNode(String s){ return false; } //note: I personally find it easiest to make this return a Node,(that being the node splayed to root), you are however free to do what you wish.
  public BST_Node insertNode(String s){ return false; } //Really same logic as above note
  public boolean removeNode(String s){ return false; } //I personal do not use the removeNode internal method in my impl since it is rather easily done in SPLT, feel free to try to delegate this out, however we do not "remove" like we do in BST
  public BST_Node findMax(){ return right; }
  public int getHeight(){ return 0; }

  private void splay(BST_Node toSplay) { return false; } //you could have this return or take in whatever you want..so long as it will do the job internally. As a caller of SPLT functions, I should really have no idea if you are "splaying or not"
                        //I of course, will be checking with tests and by eye to make sure you are indeed splaying
                        //Pro tip: Making individual methods for rotateLeft and rotateRight might be a good idea!
  */

    // --- end example methods --------------------------------------


    // --------------------------------------------------------------------
    // you may add any other methods you want to get the job done
    // --------------------------------------------------------------------

    public BST_Node containsNode(String s) {

        int flag = this.data.compareTo(s);
        if (flag == 0) {
            splay(this);
            return this;
        }
        if (flag < 0) {
            if (this.right == null) {
                splay(this);
                return this;
            } else {
                return this.right.containsNode(s);
            }
        }
        if (flag > 0) {
            if (this.left == null) {
                splay(this);
                return this;
            } else {
                return this.left.containsNode(s);
            }
        }
        return null;
    }
    public BST_Node insertNode(String s, BST_Node t){
        BST_Node ins = t;
        BST_Node par = null;
        while (ins != null) {
            par = ins;
            if (s.compareTo(par.getData()) < 0){
                ins = ins.left;
            } else if (s.compareTo(par.getData()) > 0){
                ins = ins.right;
            } else if (s == par.getData()){
                ins.justMade = false;
                splay(ins);
                return ins;
            }
        }
        ins = new BST_Node(s);
        ins.justMade = true;
        ins.parent = par;
        if (par == null){
            return ins;
        } else if (s.compareTo(par.getData()) < 0){
            par.left = ins;
        } else {
            par.right = ins;
        }
        splay(ins);
        return ins;
    }

    public BST_Node findMin() {
        if (this.left == null) {
            splay(this);
            return this;
        } else {
            return this.left.findMin();
        }
    }
    public BST_Node findMax() {
        if (this.right == null) {
            splay(this);
            return this;
        } else {
            return this.right.findMax();
        }
    }
    public int getHeight() {
        int left_height = 0;
        int right_height = 0;
        if (left != null) {
            left_height += left.getHeight() + 1;
        }
        if (right != null) {
            right_height += right.getHeight() + 1;
        }
        if(left_height > right_height){
            return left_height;
        }return right_height;

    }

    //splay method's main idea from the website "sanfoundry", rotate right
    public void makeLeftChildParent(BST_Node c, BST_Node p) {
        if ((c == null) || (p == null) || (p.left != c) || (c.parent != p)) {
            throw new RuntimeException();
        }
        if (p.parent != null) {
            if (p == p.parent.left)
                p.parent.left = c;
            else
                p.parent.right = c;
        }
        if (c.right != null)
            c.right.parent = p;

        c.parent = p.parent;
        p.parent = c;
        p.left = c.right;
        c.right = p;
    }

    //splay method main idea from the website "sanfoundry", rotate left
    public void makeRightChildParent(BST_Node c, BST_Node p) {
        if ((c == null) || (p == null) || (p.right != c) || (c.parent != p))
            throw new RuntimeException();

        if (p.parent != null) {
            if (p == p.parent.left)
                p.parent.left = c;
            else
                p.parent.right = c;
        }
        if (c.left != null)
            c.left.parent = p;

        c.parent = p.parent;
        p.parent = c;
        p.right = c.left;
        c.left = p;
    }
    //splay method main idea from the website "sanfoundry"
    public void splay(BST_Node x) {
        while (x.parent != null) {
            BST_Node Parent = x.parent;
            BST_Node grandParent = Parent.parent;
            //zig
            if (grandParent == null) {
                if (x == Parent.left)
                    makeLeftChildParent(x, Parent);
                else
                    makeRightChildParent(x, Parent);
            } else
                {
                if (x == Parent.left) {
                    //zig-zig LL
                    if (Parent == grandParent.left) {
                        makeLeftChildParent(Parent, grandParent);
                        makeLeftChildParent(x, Parent);
                        //zig-zag LR
                    } else {
                        makeLeftChildParent(x, x.parent);
                        makeRightChildParent(x, x.parent);
                    }
                } else if (x == Parent.right) {
                    //zig-zig RR
                    if (Parent == grandParent.right) {
                        makeRightChildParent(Parent, grandParent);
                        makeRightChildParent(x, Parent);
                        //zig-zag RL
                    } else {
                        makeRightChildParent(x, x.parent);
                        makeLeftChildParent(x, x.parent);
                    }
                }
            }
        }
    }

    //findnode for the previous try.
    private BST_Node findNode(String s){
        if(s.compareTo(data)<0)
            return left.findNode(s);
        else if(s.compareTo(data)>0)
            return right.findNode(s);
        return this;
    }
}

