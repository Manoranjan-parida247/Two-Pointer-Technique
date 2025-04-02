//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            int mat[][] = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) mat[i][j] = sc.nextInt();
            }
            Solution obj = new Solution();
            int ans = obj.orangesRotting(mat);
            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public int orangesRotting(int[][] mat) {
        // Code here
        int n = mat.length, m = mat[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int freshCount = 0, time = 0;

        // Step 1: Find all rotten oranges and count fresh oranges
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 2) {
                    queue.offer(new int[]{i, j}); // Store rotten oranges
                } else if (mat[i][j] == 1) {
                    freshCount++; // Count fresh oranges
                }
            }
        }

        // If there are no fresh oranges, return 0 (nothing to rot)
        if (freshCount == 0) return 0;

        // Step 2: BFS to spread rotting process
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // Up, Down, Left, Right

        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean rotted = false; // Track if any orange rots in this step

            for (int i = 0; i < size; i++) {
                int[] rotten = queue.poll();
                int r = rotten[0], c = rotten[1];

                // Try rotting adjacent fresh oranges
                for (int[] dir : directions) {
                    int newRow = r + dir[0];
                    int newCol = c + dir[1];

                    if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && mat[newRow][newCol] == 1) {
                        mat[newRow][newCol] = 2; // Mark as rotten
                        queue.offer(new int[]{newRow, newCol});
                        freshCount--; // Decrease fresh orange count
                        rotted = true;
                    }
                }
            }

            if (rotted) time++; // Increment time only if we rot any orange
        }

        // Step 3: If any fresh oranges remain, return -1
        return (freshCount == 0) ? time : -1;
    }
}