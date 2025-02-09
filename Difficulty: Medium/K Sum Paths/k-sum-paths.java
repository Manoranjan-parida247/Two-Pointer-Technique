//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

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

class GFG {
    static Node buildTree(String str) {
        // Corner Case
        if (str.length() == 0 || str.equals('N')) return null;
        String[] s = str.split(" ");

        Node root = new Node(Integer.parseInt(s[0]));
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);

        // Starting from the second element
        int i = 1;
        while (!q.isEmpty() && i < s.length) {
            // Get and remove the front of the queue
            Node currNode = q.remove();

            // Get the current node's value from the string
            String currVal = s[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                q.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= s.length) break;
            currVal = s[i];

            // If the right child is not null
            if (!currVal.equals("N")) {

                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                q.add(currNode.right);
            }

            i++;
        }

        return root;
    }

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t > 0) {
            String s = br.readLine();
            Node root = buildTree(s);
            int k = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();

            System.out.println(ob.sumK(root, k));
            t--;

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


/*
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
*/

class Solution {
    public int sumK(Node root, int k) {
        // code here
        if (root == null) {
            return 0;
        }

        HashMap<Integer, Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0, 1); // Base case to handle when the path sum equals k at the root
        return countPathsWithSum(root, k, 0, prefixSumCount);
    }
    
    private int countPathsWithSum(Node node, int target, int runningSum, HashMap<Integer, Integer> prefixSumCount) {
        if (node == null) {
            return 0;
        }

        runningSum += node.data;
        int sum = runningSum - target;
        int totalPaths = prefixSumCount.getOrDefault(sum, 0);

        prefixSumCount.put(runningSum, prefixSumCount.getOrDefault(runningSum, 0) + 1);

        totalPaths += countPathsWithSum(node.left, target, runningSum, prefixSumCount);
        totalPaths += countPathsWithSum(node.right, target, runningSum, prefixSumCount);

        prefixSumCount.put(runningSum, prefixSumCount.get(runningSum) - 1);

        return totalPaths;
    }
}