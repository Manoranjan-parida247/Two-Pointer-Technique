//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine().trim());

        Solution solution = new Solution();
        while (t-- > 0) {
            String input = reader.readLine().trim();
            String[] parts = input.split("\\s+");
            int[] arr = Arrays.stream(parts).mapToInt(Integer::parseInt).toArray();

            System.out.println(solution.findMissing(arr));

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int findMissing(int[] arr) {
        // code here
        int n = arr.length;

        // Calculate minimum adjacent difference (works for both ascending and descending)
        int d = arr[1] - arr[0];
        for (int i = 2; i < n; i++) {
            int currentDiff = arr[i] - arr[i - 1];
            if (Math.abs(currentDiff) < Math.abs(d)) {
                d = currentDiff;
            }
        }

        // Binary search to find the missing element
        int low = 0, high = n - 2;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid + 1] - arr[mid] != d) {
                return arr[mid] + d;
            }

            // Expected value at mid
            int expected = arr[0] + mid * d;

            if (arr[mid] == expected) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        // If all differences match, return the next expected value
        return arr[0] + n * d;
    }
}
