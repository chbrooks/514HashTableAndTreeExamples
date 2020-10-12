import java.util.PriorityQueue;

public class Tree {

    private Node treeNode;

    public Tree() {
        treeNode = null;
    }

    public Tree(String d, Tree leftTree, Tree rightTree) {
        this.treeNode = new Node();
        this.treeNode.left = leftTree.treeNode;
        this.treeNode.right = rightTree.treeNode;
    }

    class Node {
        String data;
        Node left;
        Node right;

        Node() {
            data = "";
            left = null;
            right = null;
        }
        Node(String s) {
            data = s;
            left = null;
            right = null;
        }

        void insertChild(Node child) {
            if (child.data.compareTo(this.data) < 0) {
                if (this.left == null) {
                    this.left = child;
                } else {
                    this.left.insertChild(child);
                }
            } else if (child.data.compareTo(this.data) > 0) {
                if (this.right == null) {
                    this.right = child;
                } else {
                    this.right.insertChild(child);
                }
            } else {
                System.out.println("Duplicate");
            }
        }
        boolean isLeaf() {
            if (left == null && right == null) {
                return true;
            } else {
                return false;
            }
        }

    }

    public boolean isEmpty() {
        return (treeNode == null);
    }


    static void inOrder(Node currentNode) {
        if (currentNode == null) {
            return;
        } else {
            inOrder(currentNode.left);
            System.out.println(currentNode.data);
            inOrder(currentNode.right);
        }
    }

    public void inOrder() {
        inOrder(treeNode);
    }



    public void preOrder() {
        preOrder(treeNode);
    }

    static void preOrder(Node currentNode) {
        if (currentNode == null) {
            return;
        } else {
            System.out.println(currentNode.data);
            preOrder(currentNode.left);
            preOrder(currentNode.right);
        }
    }

    public void postOrder() {
        postOrder(treeNode);
    }

    static void postOrder(Node currentNode) {
        if (currentNode == null) {
            return;
        } else {
            postOrder(currentNode.left);
            postOrder(currentNode.right);
            System.out.println(currentNode.data);
        }
    }




    static int height(Node n) {
        if (n == null) {
            return 0;
        } else {
            return 1 + Integer.max(height(n.left), height(n.right));
        }
    }

    public int height() {
        return height(treeNode);
    }

    public void insert(String data) {
        Node newNode = new Node(data);
        if (treeNode == null) {
            treeNode = newNode;
        } else {
            treeNode.insertChild(newNode);
        }
    }



}
