public class Tree {

    class Node {
        private int data;
        private Node left;
        private Node right;

        public Node(int x) {
            data = x;
        }

        public void setLeft(Node n) {
            left = n;
        }

        public void setRight(Node n) {
            right = n;
        }

        public void setData(int x) {
            data = x;
        }

        public Node getLeft() {
            return left;
        }

        public Node getRight() {
            return right;
        }

        public int getData() {
            return data;
        }

        public String toString() {
            return super.toString() + " " + data;
        }
    }

    private Node root;

    public void insert(int x) {
        if (root == null) {
            root = new Node(x);
        }
        else if (find(x) == null) { // Makes sure that the value does not already exist in the tree
            insertHelper(root, x);
        }
    }
    public Node insertHelper(Node parent, int x) {
        if (parent == null) {
            Node tmp = new Node(x);
            return tmp;
        }
        else if (parent.getData() > x) {
            parent.setLeft(insertHelper(parent.getLeft(), x));
        }
        else {
            parent.setRight(insertHelper(parent.getRight(), x));
        }
        return parent;
    }

    public boolean remove(int x) {
        if (root.getData() == x) {
            return removeHelper(root, root, x);
        }
        else if (root.getData() > x && root.getLeft() != null) {
            return removeHelper(root.getLeft(), root, x);
        }
        else if (root.getData() < x && root.getRight() != null) {
            return removeHelper(root.getRight(), root, x);
        }
        else {
            return false;
        }
    }
    public boolean removeHelper(Node current, Node parent, int x) {
        if (current == null) {
            return false;
        }
        if (current.getData() == x) {
            Node p = current;
            Node c;
            if (current.getLeft() != null) {
                c = current.getLeft();
                if (c.getRight() != null) {
                    while (c.getRight() != null) {
                        p = c;
                        c = c.getRight();
                    }
                    p.setRight(null);
                }
                else {
                    p.setLeft(null);
                }
            }
            else if (current.getRight() != null) {
                c = current.getRight();
                if (c.getRight() != null) {
                    while (c.getLeft() != null) {
                        p = c;
                        c = c.getLeft();
                    }
                    p.setLeft(null);
                }
                else {
                    p.setRight(null);
                }
            }
            else {
                if (parent.getLeft() == current) {
                    parent.setLeft(null);
                }
                else {
                    parent.setRight(null);
                }
                return true;
            }
            current.setData(c.getData());
            return true;
        }
        else if (current.getData() > x) {
            return removeHelper(current.getLeft(), current, x);
        }
        else {
            return removeHelper(current.getRight(), current, x);
        }
    }

    public Node find(int x) {
        Node tmp = root;
        while (tmp != null) {
            if (tmp.getData() == x) {
                return tmp;
            }
            else if (tmp.getData() > x) {
                tmp = tmp.getLeft();
            }
            else {
                tmp = tmp.getRight();
            }
        }
        return null;
    }

    public String toString() {
        return toStringHelper(root);
    }
    public String toStringHelper(Node parent) {
        String tmp = "";
        if (parent == null || (parent.getLeft() == null && parent.getRight() == null && parent != root)) {
            return tmp;
        }
        if (parent.getLeft() != null) {
            tmp += parent.getLeft().getData() + " <\t";
        }
        else {
            tmp += "\t";
        }
        tmp += parent.getData();
        if (parent.getRight() != null) {
            tmp += "\t> " + parent.getRight().getData();
        }
        tmp += "\n";
        return tmp + toStringHelper(parent.getLeft()) + toStringHelper(parent.getRight());
    }

}
