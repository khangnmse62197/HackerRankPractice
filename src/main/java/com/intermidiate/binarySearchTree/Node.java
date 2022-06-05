package main.java.com.intermidiate.binarySearchTree;

public class Node {
    private Node left;
    private Node right;
    private Integer value;

    public Node(Node left, Node right, Integer value) {
        this.left = left;
        this.right = right;
        this.value = value;
    }

    public Node() {
    }

    public Node(Integer value) {
        this.value = value;
    }
    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", left=" + left +
                ", right=" + right +
                '}';
    }

}
