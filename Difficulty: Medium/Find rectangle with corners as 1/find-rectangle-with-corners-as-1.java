class Solution {
    public boolean ValidCorner(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        // For every pair of columns
        for (int c1 = 0; c1 < m; c1++) {
            for (int c2 = c1 + 1; c2 < m; c2++) {
                int count = 0;

                // Check each row
                for (int r = 0; r < n; r++) {
                    if (mat[r][c1] == 1 && mat[r][c2] == 1) {
                        count++;
                        // If we have found two rows, rectangle exists
                        if (count >= 2) return true;
                    }
                }
            }
        }
        return false;
    }
}
