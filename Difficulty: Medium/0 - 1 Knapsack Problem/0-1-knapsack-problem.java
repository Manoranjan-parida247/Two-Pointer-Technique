//{ Driver Code Starts
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());

        while (testCases-- > 0) {
            int capacity = Integer.parseInt(br.readLine());
            String[] valInput = br.readLine().split(" ");
            String[] wtInput = br.readLine().split(" ");

            int[] val = new int[valInput.length];
            int[] wt = new int[wtInput.length];

            for (int i = 0; i < valInput.length; i++) {
                val[i] = Integer.parseInt(valInput[i]);
            }

            for (int i = 0; i < wtInput.length; i++) {
                wt[i] = Integer.parseInt(wtInput[i]);
            }

            System.out.println(Solution.knapsack(capacity, val, wt));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    static int solve(int capacity,int[] val,int[] wt,int index,int[][] dp){
        if(index==0){
            if(wt[0]<=capacity){
                return val[0];
            }else{
                return 0;
            }
        }
        if(dp[index][capacity] != -1){
            return dp[index][capacity];
        }
        int include = 0;
        if(wt[index]<=capacity){
            include = val[index]+solve(capacity-wt[index],val,wt,index-1,dp);
        }
        int exclude = solve(capacity,val,wt,index-1,dp);
        return dp[index][capacity] = Math.max(include,exclude);
    }
    
    static int knapsack(int W, int val[], int wt[]) {
        int[][] dp = new int[val.length][W+1];
        for(int i=0;i<val.length;i++){
            for(int j=0;j<W+1;j++){
                dp[i][j]=-1;
            }
        }
        return solve(W,val,wt,val.length-1,dp);
        
    }
}
