import java.util.*;

class Solution {
    public int countPaths(int[][] edges, int V, int src, int dest) {
        // Step 1: Build adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
        }

        // Step 2: Create memo array
        Integer[] memo = new Integer[V];

        // Step 3: Call DFS with memoization
        return dfs(src, dest, adj, memo);
    }

    private int dfs(int curr, int dest, List<List<Integer>> adj, Integer[] memo) {
        if (curr == dest) return 1;
        if (memo[curr] != null) return memo[curr];

        int count = 0;
        for (int neighbor : adj.get(curr)) {
            count += dfs(neighbor, dest, adj, memo);
        }

        memo[curr] = count;  // Cache the result
        return count;
    }
}
