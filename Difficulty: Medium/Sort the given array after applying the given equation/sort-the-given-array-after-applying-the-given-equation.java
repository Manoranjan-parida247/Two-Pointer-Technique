//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Read number of test cases
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            // Read the array line and convert to int[]
            String input = br.readLine().trim();
            String[] tokens = input.split("\\s+");
            int n = tokens.length;
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(tokens[i]);
            }

            // Read a, b, c from separate lines
            int a = Integer.parseInt(br.readLine().trim());
            int b = Integer.parseInt(br.readLine().trim());
            int c = Integer.parseInt(br.readLine().trim());

            // Call the solution method
            Solution obj = new Solution();
            ArrayList<Integer> ans = obj.sortArray(arr, a, b, c);

            // Output the result
            for (int num : ans) {
                System.out.print(num + " ");
            }
            System.out.println();
            System.out.println("~");
        }
    }
}

// } Driver Code Ends




class Solution {
    // Method to evaluate the quadratic equation for a given x
    private int evaluate(int x, int A, int B, int C) {
        return A * x * x + B * x + C;
    }
    public ArrayList<Integer> sortArray(int[] arr, int A, int B, int C) {
        int n = arr.length;
        ArrayList<Integer> result = new ArrayList<>(Collections.nCopies(n, 0)); // Initialize list with size n

        int l   = 0;                                                            // Left pointer
        int r   = n - 1;                                                        // Right pointer
        int idx = (A >= 0) ? n - 1 : 0;                                         // Start filling from end if A >= 0, else from start

        while (l <= r) {
            int leftVal  = evaluate(arr[l], A, B, C);
            int rightVal = evaluate(arr[r], A, B, C);

            if (A >= 0) {
                // Parabola opens upward → fill larger values at the end
                if (leftVal > rightVal) {
                    result.set(idx--, leftVal);
                    l++;
                } else {
                    result.set(idx--, rightVal);
                    r--;
                }
            } else {
                // Parabola opens downward → fill smaller values at the start
                if (leftVal < rightVal) {
                    result.set(idx++, leftVal);
                    l++;
                } else {
                    result.set(idx++, rightVal);
                    r--;
                }
            }
        }

        return result; // Return the sorted transformed list
    }
}

