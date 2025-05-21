class Solution {
    public int kthSmallest(int m, int n, int k) {
        int low = 1, high = m * n;
        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int count = countLessEqual(mid, m, n);

            if (count >= k) {
                ans = mid;         // potential answer
                high = mid - 1;    // try to find smaller
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    private int countLessEqual(int x, int m, int n) {
        int count = 0;
        for (int i = 1; i <= m; i++) {
            count += Math.min(n, x / i);
        }
        return count;
    }
}
