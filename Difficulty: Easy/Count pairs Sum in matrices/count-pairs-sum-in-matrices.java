// import java.util.*;

class Solution {
    int countPairs(int[][] mat1, int[][] mat2, int x) {
        Set<Integer> set = new HashSet<>();
        int n = mat1.length;
        int count = 0;

        // Add all elements of mat2 to the set
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                set.add(mat2[i][j]);
            }
        }

        // For each element in mat1, check if (x - mat1[i][j]) exists in mat2
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int complement = x - mat1[i][j];
                if (set.contains(complement)) {
                    count++;
                }
            }
        }

        return count;
    }
}
