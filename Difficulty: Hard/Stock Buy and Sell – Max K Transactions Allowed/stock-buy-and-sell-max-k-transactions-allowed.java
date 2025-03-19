//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        for (int t = 0; t < tc; t++) {
            String[] input = br.readLine().split(" ");
            int arr[] = new int[input.length];

            for (int i = 0; i < arr.length; i++) arr[i] = Integer.parseInt(input[i]);

            // Read the integer k
            int k = Integer.parseInt(br.readLine());

            // Call the solution function
            Solution obj = new Solution();
            System.out.println(obj.maxProfit(arr, k));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    static int dp[][][];
    static int maxProfit(int prices[], int k) {
        dp = new int[prices.length][k+1][2];
        
        for (int[][] row : dp) {
            for (int[] col : row) {
                Arrays.fill(col, -1);
            }
        }
        
        return solve(prices,k,0,0);
    }
    
    static int solve(int prices[], int k, int idx, int holding){
        if(idx == prices.length){
            return 0;
        }
        if(k == 0){
            return 0;
        }
        
        if(dp[idx][k][holding] != -1){
            return dp[idx][k][holding];
        }
        int transaction = 0;
        if(holding == 1){
            transaction = prices[idx] + solve(prices,k-1,idx+1,0);
        } else {
            transaction = -prices[idx] + solve(prices,k,idx+1,1);
        }
        int np_transact = solve(prices,k,idx+1,holding);
        return dp[idx][k][holding] = Math.max(transaction, np_transact);
    }
}