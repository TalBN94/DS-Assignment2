public class BacktrackingBST implements Backtrack, ADTSet<BacktrackingBST.Node> {
    private Stack stack;
    private Stack redoStack;
    BacktrackingBST.Node root = null;
    BacktrackingBST.Node max;
    BacktrackingBST.Node min;

    // Do not change the constructor's signature
    public BacktrackingBST(Stack stack, Stack redoStack) {
        this.stack = stack;
        this.redoStack = redoStack;
    }

    public Node getRoot() {
        return root;
    }
	
    public Node search(int x) {
        Node current=root;
        while (current!=null && current.getKey()!=x) {
            if (current.getKey()<x)
                current=current.right;
            else
                current=current.left;
        }
        return current;
    }

    public void insert(BacktrackingBST.Node z) {
        Node current=root;
        Node parent=null;
        while (current!=null) {
            parent=current;
            if (current.getKey()<z.getKey())
                current=current.right;
            else
                current=current.left;
        }
        z.setParent(parent);
        if (parent==null)
            root=z;
        else if (parent.getKey()<z.getKey())
            parent.right=z;
        else
            parent.left=z;
    }

    public void delete(Node x) {
        Node toDelete=search(x.getKey());
        if (toDelete!=null) {
            Node parent = toDelete.getParent();
            if (toDelete.left == null && toDelete.right == null) {
                if (parent == null)
                    root = null;
                else if (parent.right == toDelete)
                    parent.right = null;
                else
                    parent.left=null;
            }
            else {
                if (toDelete.left==null) {
                    if (parent==null)
                        root=toDelete.right;
                    else if (parent.right==toDelete)
                        parent.right=toDelete.right;
                    else
                        parent.left=toDelete.right;
                }
                else if (toDelete.right==null) {
                    if (parent==null)
                        root=toDelete.left;
                    else if (parent.right==toDelete)
                        parent.right=toDelete.left;
                    else
                        parent.left=toDelete.left;
                }
                else {
                    
                }
            }
        }
    }

    public Node minimum() {
        Node current=root;
        while (current!=null && current.left!=null)
            current=current.left;
        return current;
    }

    public Node maximum() {
        Node current=root;
        while (current!=null && current.right!=null)
            current=current.right;
        return current;
    }

    public Node successor(Node x) {
        Node current;
        if (x!=null) {
            if (x.right != null) {
                current = x.right;
                while (current.left != null)
                    current = current.left;
                return current;
            }
            current=x;
            Node parent=current.getParent();
            while (parent!=null && current==parent.right) {
                current=parent;
                parent=parent.getParent();
            }
            return parent;
        }
        return null;
    }

    public Node predecessor(Node x) {
        Node current;
        if (x!=null) {
            if (x.left != null) {
                current = x.left;
                while (current.right != null)
                    current = current.right;
                return current;
            }
            current=x;
            Node parent=current.getParent();
            while (parent!=null && current==parent.left) {
                current=parent;
                parent=parent.getParent();
            }
            return parent;
        }
        return null;
    }

    @Override
    public void backtrack() {
        // TODO: implement your code here
    }

    @Override
    public void retrack() {
        // TODO: implement your code here
    }

    public void printPreOrder(){
        Node current=root;
        Node left=root.left;
        Node right;
        System.out.print(current.getKey()+" ");
        while (left!=null) {
            current=left;
            System.out.print(current.getKey()+" ");
            left=current.left;
        }
    }

    @Override
    public void print() {
        // TODO: implement your code here
    }

    public static class Node{
    	//These fields are public for grading purposes. By coding conventions and best practice they should be private.
        public BacktrackingBST.Node left;
        public BacktrackingBST.Node right;
        
        private BacktrackingBST.Node parent;
        private int key;
        private Object value;

        public Node(int key, Object value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return key;
        }

        public Object getValue() {
            return value;
        }

        public Node getParent() {
            return parent;
        }

        public void setParent(Node parent) {
            this.parent=parent;
        }
    }

}
