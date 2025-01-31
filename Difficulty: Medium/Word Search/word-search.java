//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt(); // Number of test cases
        while (tc-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            char[][] mat = new char[n][m];

            // Reading the matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    mat[i][j] = sc.next().charAt(0);
                }
            }

            String word = sc.next();
            Solution obj = new Solution();
            boolean ans = obj.isWordExist(mat, word);
            if (ans)
                System.out.println("true");
            else
                System.out.println("false");

            System.out.println("~");
        }
        sc.close();
    }
}
// } Driver Code Ends


class Solution {
    static public boolean isWordExist(char[][] mat, String word) {
        int n = mat.length;
        int m = mat[0].length;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == word.charAt(0)) { // Start DFS if first letter matches
                    if (dfs(mat, word, i, j, 0, new boolean[n][m])) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    private static boolean dfs(char[][] mat, String word, int i, int j, int index, boolean[][] visited) {
        if (index == word.length()) {
            return true;
        }
        
        if (i < 0 || i >= mat.length || j < 0 || j >= mat[0].length || visited[i][j] || mat[i][j] != word.charAt(index)) {
            return false;
        }
        
        visited[i][j] = true; // Mark the cell as visited
        
        // Check all 4 possible directions (up, down, left, right)
        boolean found = dfs(mat, word, i + 1, j, index + 1, visited) ||
                        dfs(mat, word, i - 1, j, index + 1, visited) ||
                        dfs(mat, word, i, j + 1, index + 1, visited) ||
                        dfs(mat, word, i, j - 1, index + 1, visited);
        
        visited[i][j] = false; // Unmark the cell (backtracking)
        return found;
    }
}
