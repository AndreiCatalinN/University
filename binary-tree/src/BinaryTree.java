import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    Node root;

    private boolean containsNodeRecursive(Node current, int val) {
        if (current == null) { return false; }

        if (current.data == val) { return true; }

        return val < current.data
                ? containsNodeRecursive(current.left, val)
                : containsNodeRecursive(current.right, val);
    }

    public void traverseInOrder(Node node) {
        if (node != null) {
            traverseInOrder(node.left);
            System.out.print(" " + node.data);
            traverseInOrder(node.right);
        }
    }

    public void traversePreOrder(Node node) {
        if (node != null) {
            System.out.print(" " + node.data);
            traversePreOrder(node.left);
            traversePreOrder(node.right);
        }
    }

    public void traversePostOrder(Node node) {
        if (node != null) {
            traversePostOrder(node.left);
            traversePostOrder(node.right);
            System.out.print(" " + node.data);
        }
    }

    public void traverseBreathFirst(){

        // if btree is empty, exit
        if(root == null) { return; }

        Queue<Node> nodes = new LinkedList<>();
        nodes.add(root);

        while(!nodes.isEmpty()) {
            // get node, remove it from queue
            Node node = nodes.remove();

            System.out.print(" " + node.data);
            // go on left node, add it to the queue
            if (node.left != null) {  nodes.add(node.left); }
            // go on right node, add it to the queue
            if (node.right!= null) { nodes.add(node.right); }
        }
    }

    public boolean containsNode(int value) {
        return containsNodeRecursive(root, value);
    }

    public void add(int value) {
        root = addRecursive(root, value);
    }

    private Node addRecursive(Node current, int value) {

        if (current == null) {
            return new Node(value);
        }

        if (value < current.data) {
            current.left = addRecursive(current.left, value);
        } else if (value > current.data) {
            current.right = addRecursive(current.right, value);
        }
        return current;
    }

    public void delete(int value) {
        root = deleteRecursive(root, value);
    }

    private Node deleteRecursive(Node current, int value) {
        // no other value
        if (current == null) {
            return null;
        }

        // found my node
        if (value == current.data) {
            // delete a node with no children
            if (current.left == null && current.right == null) {
                return null;
            }
            //if node has only right child
            if (current.left == null) {
                return current.right;
            }
            //if node has only left child
            if (current.right == null) {
                return current.left;
            }

            //if it has 2 children, delete them too
            return current;
        }

        // search on left branch
        if (value < current.data) {
            current.left = deleteRecursive(current.left, value);
            return current;
        }

        //search on right branch
        current.right = deleteRecursive(current.right, value);
        return current;
    }

    public static BinaryTree createBinaryTree() {
        BinaryTree bt = new BinaryTree();
        try {
            bt.add(6);
            bt.add(4);
            bt.add(8);
            bt.add(3);
            bt.add(5);
            bt.add(7);
            bt.add(9);
        } catch (Exception e) {
            System.out.println("exception occured\n" + e);
        }
        return bt;
    }
}
