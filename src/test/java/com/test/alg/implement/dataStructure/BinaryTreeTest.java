package com.test.alg.implement.dataStructure;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTest {

    @AfterEach
    void afterEach() {
        System.out.println();
    }

    @Test
    void makeTree() {
        BinaryTree tree = new BinaryTree();
        TreeNode<Integer> node3 = new TreeNode<>(4, null, null);
        TreeNode<Integer> node2 = new TreeNode<>(3, null, null);
        TreeNode<Integer> node1 = new TreeNode<>(2, node3, null);
        TreeNode<Integer> root = new TreeNode<>(1, node1, node2);

        tree.setRoot(root);

        assertEquals(1, tree.getRoot().getVal());
    }

    @Test
    void tree_preorder_traversal() {
        //      1
        //     /  \
        //    2    3
        //   / \
        //  4   5
        BinaryTree tree = new BinaryTree();
        TreeNode<Integer> node4 = new TreeNode<>(5, null, null);
        TreeNode<Integer> node3 = new TreeNode<>(4, null, null);
        TreeNode<Integer> node2 = new TreeNode<>(3, null, null);
        TreeNode<Integer> node1 = new TreeNode<>(2, node3, node4);
        TreeNode<Integer> root = new TreeNode<>(1, node1, node2);

        tree.setRoot(root);

        tree.preOrder(tree.getRoot());
    }

    @Test
    void tree_inorder_traversal() {
        BinaryTree tree = new BinaryTree();
        TreeNode<Integer> node4 = new TreeNode<>(5, null, null);
        TreeNode<Integer> node3 = new TreeNode<>(4, null, null);
        TreeNode<Integer> node2 = new TreeNode<>(3, null, null);
        TreeNode<Integer> node1 = new TreeNode<>(2, node3, node4);
        TreeNode<Integer> root = new TreeNode<>(1, node1, node2);

        tree.setRoot(root);

        tree.inOrder(tree.getRoot());
    }

    @Test
    void tree_postorder_traversal() {
        BinaryTree tree = new BinaryTree();
        TreeNode<Integer> node4 = new TreeNode<>(5, null, null);
        TreeNode<Integer> node3 = new TreeNode<>(4, null, null);
        TreeNode<Integer> node2 = new TreeNode<>(3, null, null);
        TreeNode<Integer> node1 = new TreeNode<>(2, node3, node4);
        TreeNode<Integer> root = new TreeNode<>(1, node1, node2);

        tree.setRoot(root);

        tree.postOrder(tree.getRoot());
    }

    @Test
    void tree_level_order_traversal() {
        BinaryTree tree = new BinaryTree();
        TreeNode<Integer> node4 = new TreeNode<>(5, null, null);
        TreeNode<Integer> node3 = new TreeNode<>(4, null, null);
        TreeNode<Integer> node2 = new TreeNode<>(3, null, null);
        TreeNode<Integer> node1 = new TreeNode<>(2, node3, node4);
        TreeNode<Integer> root = new TreeNode<>(1, node1, node2);

        tree.setRoot(root);

        tree.levelOrder(tree.getRoot());
    }

    @Test
    void isSymmetric() {
        BinaryTree tree = new BinaryTree();
        TreeNode<Integer> node4 = new TreeNode<>(5, null, null);
        TreeNode<Integer> node3 = new TreeNode<>(4, null, null);
        TreeNode<Integer> node2 = new TreeNode<>(3, null, null);
        TreeNode<Integer> node1 = new TreeNode<>(2, node3, node4);
        TreeNode<Integer> root = new TreeNode<>(1, node1, node2);

        tree.setRoot(root);

        BinaryTree tree2 = new BinaryTree();
        TreeNode<Integer> node31 = new TreeNode<>(4, null, null);
        TreeNode<Integer> node21 = new TreeNode<>(3, null, null);
        TreeNode<Integer> node11 = new TreeNode<>(2, node31, null);
        TreeNode<Integer> root2 = new TreeNode<>(1, node11, node21);

        tree2.setRoot(root2);

        assertAll(
                () -> assertTrue(tree.isSymmetric(tree.getRoot())),
                () -> assertEquals(false, tree2.isSymmetric(tree2.getRoot()))
        );


    }
}