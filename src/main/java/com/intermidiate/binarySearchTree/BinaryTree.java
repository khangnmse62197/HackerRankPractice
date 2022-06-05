package main.java.com.intermidiate.binarySearchTree;

public class BinaryTree {
    private Node root;

    public BinaryTree(Node root) {
        this.root = root;
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public void insert(final int x){
        this.root = insert(this.root, x);
    }

    @Override
    public String toString() {
        return "BinaryTree{" +
                "root=" + root +
                '}';
    }

    private Node insert(Node node, final int x){
        if (node == null) {
            return new Node(x);
        }

        if (node.getValue() == x) {
            throw new IllegalArgumentException(String.format(
                    "Node with value %s already existed ", x
            ));
        }

        if (node.getValue() < x) {
            node.setLeft(insert(node.getLeft(), x));
        }

        if (node.getValue() > x) {
            node.setRight(insert(node.getRight(), x));
        }

        return node;

    }
}
