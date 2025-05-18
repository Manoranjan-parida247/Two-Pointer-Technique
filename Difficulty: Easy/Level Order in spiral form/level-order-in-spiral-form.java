//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;
import java.util.LinkedList;
import java.util.Queue;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class GfG {

    static Node buildTree(String str) {

        if (str.length() == 0 || str.charAt(0) == 'N') {
            return null;
        }

        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue

        Queue<Node> queue = new LinkedList<>();

        queue.add(root);
        // Starting from the second element

        int i = 1;
        while (queue.size() > 0 && i < ip.length) {

            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();

            // Get the current node's value from the string
            String currVal = ip[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= ip.length) break;

            currVal = ip[i];

            // If the right child is not null
            if (!currVal.equals("N")) {

                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }

    void inOrder(Node node) {
        if (node == null) {
            return;
        }

        inOrder(node.left);
        System.out.print(node.data + " ");

        inOrder(node.right);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String s = br.readLine();
            Node root = buildTree(s);
            Solution g = new Solution();
            ArrayList<Integer> result = g.findSpiral(root);
            for (int value : result) System.out.print(value + " ");
            System.out.println();

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


/*
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
*/
class Solution {
    public ArrayList<Integer> findSpiral(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Stack<Node> stack1 = new Stack<>(); // for even levels (right to left)
        Stack<Node> stack2 = new Stack<>(); // for odd levels (left to right)

        stack1.push(root);

        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            // Process current level from stack1 (right to left)
            while (!stack1.isEmpty()) {
                Node curr = stack1.pop();
                result.add(curr.data);

                // push children: right first, then left
                if (curr.right != null) stack2.push(curr.right);
                if (curr.left != null) stack2.push(curr.left);
            }

            // Process current level from stack2 (left to right)
            while (!stack2.isEmpty()) {
                Node curr = stack2.pop();
                result.add(curr.data);

                // push children: left first, then right
                if (curr.left != null) stack1.push(curr.left);
                if (curr.right != null) stack1.push(curr.right);
            }
        }

        return result;
    }
}
