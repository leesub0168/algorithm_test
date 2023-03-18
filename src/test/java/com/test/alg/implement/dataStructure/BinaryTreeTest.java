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

    @Test
    void bfs() {
        BinaryTree tree = new BinaryTree();
        TreeNode<Integer> node11 = new TreeNode<>(5, null, null);
        TreeNode<Integer> node12 = new TreeNode<>(6, null, null);
        TreeNode<Integer> node1 = new TreeNode<>(2, node11, node12);
        TreeNode<Integer> node2 = new TreeNode<>(3, null, null);
        TreeNode<Integer> node3 = new TreeNode<>(1, node1, node2);

        tree.setRoot(node3);

        tree.bfsSum(tree.getRoot());
    }

    @Test
    void left_leaf_sum() {
        BinaryTree twoLeftLeafTree = new BinaryTree();
        TreeNode<Integer> node11 = new TreeNode<>(15, null, null);
        TreeNode<Integer> node12 = new TreeNode<>(7, null, null);
        TreeNode<Integer> node1 = new TreeNode<>(20, node11, node12);
        TreeNode<Integer> node2 = new TreeNode<>(9, null, null);
        TreeNode<Integer> twoLeftLeafTree_root = new TreeNode<>(3, node2, node1);

        twoLeftLeafTree.setRoot(twoLeftLeafTree_root);

        BinaryTree noLeafTree = new BinaryTree();
        TreeNode<Integer> noLeafTree_root = new TreeNode<>(1, null, null);

        noLeafTree.setRoot(noLeafTree_root);

        BinaryTree oneLeftLeafTree = new BinaryTree();
        TreeNode<Integer> oneLeftLeafTree_2depth_right = new TreeNode<>(5, null, null);
        TreeNode<Integer> oneLeftLeafTree_1depth_right = new TreeNode<>(3, null, oneLeftLeafTree_2depth_right);
        TreeNode<Integer> oneLeftLeafTree_2depth_left = new TreeNode<>(4, null, null);
        TreeNode<Integer> oneLeftLeafTree_1depth_left = new TreeNode<>(2, oneLeftLeafTree_2depth_left, null);
        TreeNode<Integer> oneLeftLeafTree_root = new TreeNode<>(1, oneLeftLeafTree_1depth_left, oneLeftLeafTree_1depth_right);

        oneLeftLeafTree.setRoot(oneLeftLeafTree_root);


        assertAll(
                () -> assertEquals(24, twoLeftLeafTree.sum(twoLeftLeafTree.getRoot())),
                () -> assertEquals(0, noLeafTree.sum(noLeafTree.getRoot())),
                () -> assertEquals(4, oneLeftLeafTree.sum(oneLeftLeafTree.getRoot()))
        );

    }
}