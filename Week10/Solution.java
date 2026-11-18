package Week10;

import java.util.*;

public class Solution {
    Vector<Integer> values;

    private int count;

    Solution() {
        this.values = new Vector<Integer>();
        this.count = 0;
    }

    static class Node {
        int data;
        Node left;
        Node right;

        Node() {
            this.data = -1;
            this.left = null;
            this.right = null;
        }
    }

    boolean checkBST(Node root) {
        return isValid(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    boolean isValid(Node node, int min, int max) {
        if (node == null) {
            return true;
        }

        if (node.data <= min || node.data >= max) {
            return false;
        }

        return isValid(node.left, min, node.data) &&
                isValid(node.right, node.data, max);
    }

    void inOrder (Node root, int levels) {
        if(root != null) {
            if (levels > 0) {
                root.left = new Node();
                inOrder(root.left, levels - 1);
            }

            root.data = values.elementAt(count);
            count++;

            if (levels > 0) {
                root.right = new Node();
                inOrder(root.right, levels - 1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        int height = scanner.nextInt();

        Solution tree = new Solution();
        while(scanner.hasNext()) {
            tree.values.add(scanner.nextInt());
        }
        scanner.close();

        Node root = new Node();
        tree.inOrder(root, height);

        System.out.println( (tree.checkBST(root) == true) ? "Yes" : "No" );
    }
}
