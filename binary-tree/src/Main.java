/**
 * tutorial: https://www.baeldung.com/java-binary-tree
 * Author: Andrei
 * JDK: java 10
* */

public class Main {


    public static void main(String[] args) {
        Node tree = createTree();
        Node subtree = createSubTree();

        BinaryTree bt = new BinaryTree();
        int[] values = {5,4,1,12,13,7,2,6};


        for(int i =0 ;i< values.length; i++){
            bt.add(values[i]);
        }

        System.out.println("Contains 13: " +
                bt.containsNode(5)
        );

    }

    public static Node createTree() {

        Node tree = new Node(5);
        Node root = tree;

        tree.left = new Node(4);
        tree.right = new Node(1);

        tree.left.left = new Node(3);
        tree.left.right = new Node(2);

        tree.right.left = new Node(6);
        tree.right.right = new Node(7);
        return root;
    }

    public static Node createSubTree() {

        Node tree = new Node(4);
        Node root = tree;

        tree.left = new Node(3);
        tree.right = new Node(2);

        return root;
    }
}
