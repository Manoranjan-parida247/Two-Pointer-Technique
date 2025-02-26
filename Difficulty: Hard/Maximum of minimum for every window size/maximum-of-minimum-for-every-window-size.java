//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t-- > 0) {
            String line = sc.nextLine();
            String[] input = line.split(" ");
            int[] arr = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();
            Solution solution = new Solution();
            ArrayList<Integer> result = solution.maxOfMins(arr);
            for (int val : result) {
                System.out.print(val + " ");
            }
            System.out.println();
            System.out.println("~");
        }
        sc.close();
    }
}
// } Driver Code Ends



class Solution {
    public ArrayList<Integer> maxOfMins(int[] arr) {
        // Your code here
        int n = arr.length;
        ArrayList<Integer> result = new ArrayList<>(Collections.nCopies(n, 0));
        
        int[] left = new int[n];
        int[] right = new int[n];
        
        Arrays.fill(left, -1);
        Arrays.fill(right, n);
        
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                left[i] = stack.peek();
            }
            stack.push(i);
        }
        
        stack.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                right[i] = stack.peek();
            }
            stack.push(i);
        }
        
        int[] ans = new int[n + 1];
        for (int i = 0; i < n; i++) {
            int win_size = right[i] - left[i] - 1;
            ans[win_size] = Math.max(ans[win_size], arr[i]);
        }
        
        for (int i = n - 1; i >= 1; i--) {
            ans[i] = Math.max(ans[i], ans[i + 1]);
        }
        
        for (int i = 1; i <= n; i++) {
            result.set(i - 1, ans[i]);
        }
        
        return result;
    }
}