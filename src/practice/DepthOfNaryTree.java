package practice;


// @problem : https://helloacm.com/c-coding-exercise-find-maximum-depth-of-n-ary-tree/

import sun.jvm.hotspot.utilities.Assert;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DepthOfNaryTree {

    public static final int DEPTH = 3;

    public static void main(String[] args) {
        DepthOfNaryTree depthOfNaryTree = new DepthOfNaryTree();
        Node root = depthOfNaryTree.createTree();
        int depth = depthOfNaryTree.depth(root);
        if (DEPTH != depth) {
            System.out.println("Test case failed!");
            System.exit(1);
        }
        System.out.println("Test case passed!");
    }

    private Node createTree() {
        Node root = new Node(0);
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        root.children.add(a);
        root.children.add(b);
        root.children.add(c);
        root.children.add(d);
        Node e = new Node(5);
        Node f = new Node(6);
        a.children.add(e);
        a.children.add(f);
        Node g = new Node(7);
        Node h = new Node(8);
        f.children.add(g);
        f.children.add(h);
        return root;
    }

    private int depth(Node root) {
        int depth = -1;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if (null == current) {
                depth++;
                if (!queue.isEmpty()) queue.add(null);
                continue;
            }
            queue.addAll(current.children);
        }
        return depth;
    }

}

class Node {
    int value;
    List<Node> children;

    public Node(int value) {
        this.value = value;
        children = new ArrayList<>();
    }
}
