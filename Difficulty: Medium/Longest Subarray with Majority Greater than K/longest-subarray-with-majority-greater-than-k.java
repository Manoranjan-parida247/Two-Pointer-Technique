//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;


// } Driver Code Ends

// User function Template for Java
class Solution {
    static int longestSubarray(int[] arr, int k) {
        // Code Here
        int n = arr.length;
        int maxLen = 0;
        int prefixSum = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            // Convert value based on condition
            if (arr[i] > k) {
                prefixSum += 1;
            } else {
                prefixSum -= 1;
            }

            // Entire subarray from 0 to i is valid
            if (prefixSum > 0) {
                maxLen = i + 1;
            }

            // Store first occurrence of this prefixSum
            map.putIfAbsent(prefixSum, i);

            // Check if (prefixSum - 1) existed before
            if (map.containsKey(prefixSum - 1)) {
                int prevIndex = map.get(prefixSum - 1);
                maxLen = Math.max(maxLen, i - prevIndex);
            }
        }

        return maxLen;
    }
}


//{ Driver Code Starts.

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String line = br.readLine();
            String[] tokens = line.split(" ");
            int n = tokens.length;
            int[] arr = new int[n];

            int i = 0;
            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                arr[i] = Integer.parseInt(token);
                i++;
            }

            int k = Integer.parseInt(br.readLine().trim());
            System.out.println(new Solution().longestSubarray(arr, k));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends