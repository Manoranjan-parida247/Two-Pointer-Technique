

class Solution {
    Map<Integer, List<Integer>> moves = new HashMap<>();
    int[][] dp;

    public int getCount(int n) {
        // Setup possible moves for each digit
        moves.put(0, Arrays.asList(0, 8));
        moves.put(1, Arrays.asList(1, 2, 4));
        moves.put(2, Arrays.asList(2, 1, 3, 5));
        moves.put(3, Arrays.asList(3, 2, 6));
        moves.put(4, Arrays.asList(4, 1, 5, 7));
        moves.put(5, Arrays.asList(5, 2, 4, 6, 8));
        moves.put(6, Arrays.asList(6, 3, 5, 9));
        moves.put(7, Arrays.asList(7, 4, 8));
        moves.put(8, Arrays.asList(8, 5, 7, 9, 0));
        moves.put(9, Arrays.asList(9, 6, 8));

        // dp[digit][length] = count of sequences starting with digit and length
        dp = new int[10][n + 1];
        for (int[] row : dp)
            Arrays.fill(row, -1);

        int total = 0;
        for (int digit = 0; digit <= 9; digit++) {
            total += count(digit, n);
        }
        return total;
    }

    private int count(int digit, int len) {
        if (len == 1) return 1;
        if (dp[digit][len] != -1) return dp[digit][len];

        int res = 0;
        for (int next : moves.get(digit)) {
            res += count(next, len - 1);
        }

        dp[digit][len] = res;
        return res;
    }
}
