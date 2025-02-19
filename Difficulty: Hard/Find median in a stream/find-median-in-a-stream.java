//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        while (t-- > 0) {
            String s = sc.nextLine();
            String[] parts = s.split(" ");
            int[] nums = new int[parts.length];
            for (int i = 0; i < parts.length; i++) {
                nums[i] = Integer.parseInt(parts[i]);
            }
            Solution ob = new Solution();
            ArrayList<Double> ans = ob.getMedian(nums);
            for (double i : ans) {
                System.out.printf("%.1f ", i);
            }
            System.out.println();
            System.out.println("~");
        }
        sc.close();
    }
}

// } Driver Code Ends


class Solution {
    public ArrayList<Double> getMedian(int[] arr) {
        // code here
        ArrayList<Double> result = new ArrayList<>();
        PriorityQueue<Integer> leftHeap = new PriorityQueue<>(Collections.reverseOrder()); // Max Heap
        PriorityQueue<Integer> rightHeap = new PriorityQueue<>(); // Min Heap
        
        for (int num : arr) {
            if (leftHeap.isEmpty() || num <= leftHeap.peek()) {
                leftHeap.offer(num);
            } else {
                rightHeap.offer(num);
            }

            // Balance the heaps
            if (leftHeap.size() > rightHeap.size() + 1) {
                rightHeap.offer(leftHeap.poll());
            } else if (rightHeap.size() > leftHeap.size()) {
                leftHeap.offer(rightHeap.poll());
            }

            // Compute the median
            if (leftHeap.size() > rightHeap.size()) {
                result.add((double) leftHeap.peek());
            } else {
                result.add((leftHeap.peek() + rightHeap.peek()) / 2.0);
            }
        }
        
        return result;
    }
}