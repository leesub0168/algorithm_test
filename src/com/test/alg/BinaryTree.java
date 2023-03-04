package com.test.alg;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Hashtable;
import java.util.Queue;
import java.util.Vector;

class Node {
    public String data;
    public Node left;
    public Node right;
}

class Tree {
    public Node root;

    public void setRoot(Node root) {
        this.root = root;
    }

    public Node getRoot() {
        return root;
    }
    public Node makeNode(Node left, String data, Node right) {
        Node node = new Node();
        node.data = data;
        node.left = left;
        node.right = right;

        return node;
    }
    public void inOrder(Node node) {
        if(node != null) {
            inOrder(node.left);
            System.out.print(node.data + " ");
            inOrder(node.right);
        }
    }

    public void preOrder(Node node) {
        if(node != null) {
            System.out.print(node.data + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    public void postOrder(Node node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.data + " ");
        }
    }

    public void levelOrder(Node node) {
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(node);

        while (!queue.isEmpty()) {
            Node node1 = queue.poll();
            System.out.print(node1.data + " ");

            if(node1.left != null) queue.offer(node1.left);
            if(node1.right != null) queue.offer(node1.right);
        }
    }

    int[] lc = {0,2,4,6,0,0,0,0,0};
    int[] rc = {0,3,5,7,0,8,0,0,0};
    public void preOrderArray(int cur) {
        System.out.print(cur + " ");
        if(lc[cur] != 0) preOrderArray(lc[cur]);
        if(rc[cur] != 0) preOrderArray(rc[cur]);
    }

    int[] adj = new int[10];
    int[] p = new int[10];
    public void tree_bfs(int root) {
        Hashtable<Integer, Integer> table = new Hashtable<>();
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int cur = queue.peek();
            queue.poll();
            System.out.print(cur + " ");
            int nxt = adj[cur];
            if(p[cur] == nxt) continue;
            queue.offer(nxt);
            p[nxt] = cur;
        }
    }


    public boolean isSymmetric(Node root) {
        System.out.println(root.data);
        System.out.println(root.data);
        if(root.left == null && root.right == null) return true;
        if(root.left != null && root.right == null) return false;
        if(root.left == null && root.right != null) return false;
        if(root.left.data == root.right.data) return true;

        return isSymmetric(root.left);
    }
}
public class BinaryTree {
    public static void main(String[] args) {
        Tree tree = new Tree();
        Node n1 = tree.makeNode(null, "3", null);
        Node n2 = tree.makeNode(null, "4", null);
        Node n3 = tree.makeNode(n1, "2", n2);

        Node n11 = tree.makeNode(null, "3", null);
        Node n21 = tree.makeNode(null, "4", null);
        Node n4 = tree.makeNode(n21, "2", n11);
        Node n5 = tree.makeNode(n3, "1", n4);

        tree.setRoot(n5);

        tree.tree_bfs(1);


//        tree.preOrderArray(1);

//        tree.inOrder(tree.getRoot());

//        tree.preOrder(tree.getRoot());

//        tree.postOrder(tree.getRoot());


//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        A B C
//        B D .
//        C E F
//        E . .
//        F . G
//        D . .
//        G . .

    }
}
