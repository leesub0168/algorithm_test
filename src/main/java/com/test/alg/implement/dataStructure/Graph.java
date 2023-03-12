package com.test.alg.implement.dataStructure;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Graph {
    Node[] nodes;

    public Graph(int vertex) {
        nodes = new Node[vertex];
        for (int i=0;i<vertex;i++) {
            nodes[i] = new Node(i);
        }
    }

    public void addEdge(int u, int v) {
        Node node1 = nodes[u];
        Node node2 = nodes[v];

        if(!node1.adj.contains(node2)) {
            node1.adj.add(node2);
        }
        if (!node2.adj.contains(node1)) {
            node2.adj.add(node1);
        }
    }

    public void dfs(int idx) {
        Stack<Node> stack = new Stack<>();
        stack.add(nodes[idx]);

        while (!stack.isEmpty()) {
            Node node = stack.pop();
            if(node.marked) continue;
            node.marked = true;
            System.out.print(node.val + " ");
            for (Node nxt : node.adj) {
                if(nxt.marked) continue;
                stack.push(nxt);
            }
        }
    }

    public void dfsRecursive(Node node) {
        if(node == null) return;
        node.marked = true;
        System.out.print(node.val + " ");
        for (Node nxt : node.adj) {
            if(nxt.marked) continue;
            dfsRecursive(nxt);
        }
    }

    public void dfsR(int idx) {
        dfsRecursive(nodes[idx]);
    }

    public void bfs(int idx) {
        Queue<Node> queue = new ArrayDeque<>();
        nodes[idx].marked = true;
        queue.add(nodes[idx]);

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            System.out.print(node.val + " ");
            for (Node nxt : node.adj) {
                if(nxt.marked) continue;
                nxt.marked = true;
                queue.add(nxt);
            }
        }
    }

    class Node {
        int val;
        LinkedList<Node> adj;
        boolean marked;

        public Node(int val) {
            this.val = val;
            marked = false;
            adj = new LinkedList<>();
        }
    }
}
