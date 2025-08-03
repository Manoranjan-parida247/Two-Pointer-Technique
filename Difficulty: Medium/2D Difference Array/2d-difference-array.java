class Solution {
    public ArrayList<ArrayList<Integer>> applyDiff2D(int[][] mat, int[][] opr) {
        int n = mat.length;
        int m = mat[0].length;
        
        // Step 1: Initialize diff matrix with size (n+1) x (m+1)
        int[][] diff = new int[n + 2][m + 2]; // extra row and column to avoid index out of bounds

        // Step 2: Apply each operation in constant time
        for (int[] op : opr) {
            int v = op[0], r1 = op[1], c1 = op[2], r2 = op[3], c2 = op[4];

            diff[r1][c1] += v;
            diff[r2 + 1][c1] -= v;
            diff[r1][c2 + 1] -= v;
            diff[r2 + 1][c2 + 1] += v;
        }

        // Step 3: Convert diff to actual matrix using prefix sum (2D)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i > 0) diff[i][j] += diff[i - 1][j];
                if (j > 0) diff[i][j] += diff[i][j - 1];
                if (i > 0 && j > 0) diff[i][j] -= diff[i - 1][j - 1];
            }
        }

        // Step 4: Add the difference values to the original matrix
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < m; j++) {
                row.add(mat[i][j] + diff[i][j]);
            }
            result.add(row);
        }

        return result;
    }
}
