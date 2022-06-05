package main.java.com.intermidiate.binarySearchTree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NodeServiceTest {


    @Test
    void insert() {
        Node root = new Node(5);
        BinaryTree binaryTree = new BinaryTree(root);

        binaryTree.insert(1);
        binaryTree.insert(3);
        binaryTree.insert(6);


        System.out.println(binaryTree);
    }
}