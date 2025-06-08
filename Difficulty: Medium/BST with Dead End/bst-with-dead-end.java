/*
class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
}*/

class Solution {
    public boolean isDeadEnd(Node root) {
        return checkDeadEnd(root, 1, Integer.MAX_VALUE);
    }

    private boolean checkDeadEnd(Node node, int min, int max) {
        if (node == null) return false;

        // Dead end condition
        if (min == max) return true;

        // Recur for left and right subtrees
        boolean leftDeadEnd = checkDeadEnd(node.left, min, node.data - 1);
        boolean rightDeadEnd = checkDeadEnd(node.right, node.data + 1, max);

        return leftDeadEnd || rightDeadEnd;
    }
}
