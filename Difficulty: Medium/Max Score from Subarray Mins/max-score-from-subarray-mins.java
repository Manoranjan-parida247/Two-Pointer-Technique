class Solution {
    // O(n) – the real answer
    public int maxSum(int[] arr) {
        int best = 0;                      // n ≥ 2 by constraints
        for (int i = 0; i < arr.length - 1; ++i) {
            best = Math.max(best, arr[i] + arr[i + 1]);
        }
        return best;
    }
}
