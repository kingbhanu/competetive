package practice.acm;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 *
 * @problem : https://helloacm.com/c-coding-exercise-how-to-merge-two-binary-trees/
 * @author  : swayam raina
 *
 */
public class MergeTwoBinaryTrees {

    public static void main(String[] args) {
        Node tree1 = createTree1();
        Node tree2 = createTree2();
        printTree(merge(tree1, tree2));
    }

    private static Node merge(Node root1, Node root2) {
        if (null == root1 && null == root2) return null;
        Node current = null;
        if (null == root1 || null == root2) {
            if (null == root1) current = new Node(root2.value);
            else current = new Node(root1.value);
        } else {
            current = new Node(root1.value + root2.value);
            current.left = merge(root1.left, root2.left);
            current.right = merge(root1.right, root2.right);
        }
        return current;
    }

    private static void printTree(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node current = queue.remove();
            if (null == current) {
                System.out.print(" NULL ");
                if (null != queue.peek()) queue.add(null);
            } else {
                System.out.print(current.value + " ");
                queue.add(current.left);
                queue.add(current.right);
            }
        }
    }

    private static Node createTree1() {
        Node root = new Node(1);
        root.left = new Node(3);
        root.right = new Node(2);
        root.left.left = new Node(5);
        return root;
    }

    private static Node createTree2() {
        Node root = new Node(2);
        root.left = new Node(1);
        root.right = new Node(3);
        root.left.right = new Node(4);
        root.right.right = new Node(7);
        return root;
    }

    static class Node {
        int value;
        Node left, right;

        Node(int value) {
            this.value = value;
        }
    }

}
