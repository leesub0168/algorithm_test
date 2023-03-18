package com.test.alg.implement.dataStructure;


import java.util.*;
import java.util.Queue;

class TreeNode<T> {
    private T val;
    private TreeNode<T> left;
    private TreeNode<T> right;

    public TreeNode(T val, TreeNode<T> left, TreeNode<T> right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public T getVal() {
        return val;
    }

    public TreeNode<T> getLeft() {
        return left;
    }

    public TreeNode<T> getRight() {
        return right;
    }
}
public class BinaryTree {
    private TreeNode root;

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    public TreeNode getRoot() {
        return root;
    }

    public void preOrder(TreeNode node) {
        if (node != null) {
            System.out.print(node.getVal() + " ");
            preOrder(node.getLeft());
            preOrder(node.getRight());
        }
    }

    public void inOrder(TreeNode node) {
        if (node != null) {
            inOrder(node.getLeft());
            System.out.print(node.getVal() + " ");
            inOrder(node.getRight());
        }
    }


    public void postOrder(TreeNode node) {
        if (node != null) {
            postOrder(node.getLeft());
            postOrder(node.getRight());
            System.out.print(node.getVal() + " ");
        }
    }

    public void levelOrder(TreeNode node) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            TreeNode n = queue.poll();
            System.out.print(n.getVal() + " ");

            if(n.getLeft() != null) queue.add(n.getLeft());
            if(n.getRight() != null) queue.add(n.getRight());
        }
    }

    public boolean isSymmetric(TreeNode node) {
        if(node.getLeft() == null && node.getRight() == null) return true;
        if(node.getLeft() == null && node.getRight() != null) return false;
        if(node.getLeft() != null && node.getRight() == null) return false;
        if(node.getLeft().getVal() == node.getRight().getVal()) return true;

        return isSymmetric(node.getLeft());
    }

    public void bfsSum(TreeNode node) {
        List<Integer> list = new ArrayList<>();
        bfs(node.getLeft(), (int) node.getVal(), list);
        bfs(node.getRight(), (int) node.getVal(), list);

        System.out.println(Arrays.toString(list.stream().mapToInt(Integer::intValue).toArray()));
    }

    public void bfs(TreeNode node, int sum, List<Integer> list) {
        sum += (int) node.getVal();
        if(node.getLeft() == null && node.getRight() == null) {
            list.add(sum);
            return;
        }
        if(node.getLeft() == null && node.getRight() != null) {
            bfs(node.getRight(), sum, list);
            return;
        }
        if(node.getLeft() != null && node.getRight() == null)  {
            bfs(node.getLeft(), sum, list);
            return;
        }
        bfs(node.getLeft(), sum, list);
        bfs(node.getRight(), sum, list);
    }

    public int sum(TreeNode root) {
        if(root == null) return 0;
        if(root.getLeft() != null && root.getLeft().getLeft() == null && root.getLeft().getRight() == null) {
            return (int) root.getLeft().getVal() + sum(root.getRight());
        }

        return sum(root.getLeft()) + sum(root.getRight());
    }

}
