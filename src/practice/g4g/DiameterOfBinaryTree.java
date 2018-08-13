package practice.g4g;


// @problem : https://www.geeksforgeeks.org/diameter-of-a-binary-tree-in-on-a-new-method/

public class DiameterOfBinaryTree {

    public static void main(String[] args) {
        DiameterOfBinaryTree diameterOfBinaryTree = new DiameterOfBinaryTree();
        Node root = diameterOfBinaryTree.createTestTree1();
        System.out.println(6 == diameterOfBinaryTree.getDiameter(root));
        root = diameterOfBinaryTree.createTestTree2();
        System.out.println(5 == diameterOfBinaryTree.getDiameter(root));
    }

    private int getDiameter(Node root) {
        if (null == root) return 0;
        int ld = getDiameter(root.left);
        int rd = getDiameter(root.right);
        root.height = 1 + Math.max(getHeight(root.left), getHeight(root.right));
        return Math.max(1+getHeight(root.left)+getHeight(root.right), Math.max(ld,rd));
    }

    private Node createTestTree1() {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);
        root.right.right.left = new Node(7);
        return root;
    }

    private Node createTestTree2() {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.left.right = new Node(6);
        root.left.right.left = new Node(7);
        return root;
    }

    private static int getHeight(Node root) {
        return (null == root) ? 0 : root.height;
    }

    static class Node {
        int height;
        int value;
        Node left, right;

        public Node(int value) {
            this.value = value;
        }
    }

}
