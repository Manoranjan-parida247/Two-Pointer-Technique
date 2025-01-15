//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine().trim()); // Read number of test cases

        while (t-- > 0) {
            String line = read.readLine().trim(); // Read the array input
            String[] numsStr = line.split(" ");   // Split the input string by spaces
            int[] nums =
                new int[numsStr.length]; // Convert string array to integer array
            for (int i = 0; i < numsStr.length; i++) {
                nums[i] = Integer.parseInt(numsStr[i]);
            }

            int k = Integer.parseInt(read.readLine().trim()); // Read target sum

            Solution ob = new Solution();
            int ans = ob.longestSubarray(nums, k); // Call the function and store result
            System.out.println(ans);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestSubarray(int[] arr, int k) {
        // code here
        HashMap<Integer, Integer> prefixSumMap = new HashMap<>();
        int currSum = 0;
        int maxLength = 0;

        for (int i = 0; i < arr.length; i++) {
            currSum += arr[i];

            // If the subarray from the start to the current index sums to k
            if (currSum == k) {
                maxLength = i + 1;
            }

            // If currSum - k is found in the map, update maxLength
            if (prefixSumMap.containsKey(currSum - k)) {
                maxLength = Math.max(maxLength, i - prefixSumMap.get(currSum - k));
            }

            // Store the current sum in the map if it's not already present
            if (!prefixSumMap.containsKey(currSum)) {
                prefixSumMap.put(currSum, i);
            }
        }

        return maxLength;
    }
}
