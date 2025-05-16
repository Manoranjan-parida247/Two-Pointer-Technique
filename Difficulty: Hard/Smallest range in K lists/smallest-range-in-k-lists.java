//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

public class DriverClass {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int arr[][] = new int[k][n];
            for (int i = 0; i < k; i++) {
                for (int j = 0; j < n; j++) arr[i][j] = sc.nextInt();
            }
            ArrayList<Integer> range = new Solution().findSmallestRange(arr);
            System.out.println(range.get(0) + " " + range.get(1));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// import java.util.*;

class Solution {
    static class Element implements Comparable<Element> {
        int value, row, col;

        Element(int value, int row, int col) {
            this.value = value;
            this.row = row;
            this.col = col;
        }

        @Override
        public int compareTo(Element other) {
            return Integer.compare(this.value, other.value);
        }
    }

    public ArrayList<Integer> findSmallestRange(int[][] arr) {
        int k = arr.length;      // Number of lists
        int n = arr[0].length;   // Length of each list

        PriorityQueue<Element> minHeap = new PriorityQueue<>();
        int currentMax = Integer.MIN_VALUE;

        // Step 1: Add the first element from each list to the heap
        for (int i = 0; i < k; i++) {
            int val = arr[i][0];
            minHeap.add(new Element(val, i, 0));
            currentMax = Math.max(currentMax, val);
        }

        // Initialize best range with max possible value
        int rangeStart = 0, rangeEnd = Integer.MAX_VALUE;

        // Step 2: Process elements
        while (true) {
            Element minElem = minHeap.poll(); // Get the smallest current element

            int currentMin = minElem.value;
            // Update the range if it's smaller
            if (currentMax - currentMin < rangeEnd - rangeStart) {
                rangeStart = currentMin;
                rangeEnd = currentMax;
            }

            // Move to the next element in the same list
            if (minElem.col + 1 < n) {
                int nextVal = arr[minElem.row][minElem.col + 1];
                minHeap.add(new Element(nextVal, minElem.row, minElem.col + 1));
                currentMax = Math.max(currentMax, nextVal);
            } else {
                // One of the lists is exhausted
                break;
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        result.add(rangeStart);
        result.add(rangeEnd);
        return result;
    }
}
