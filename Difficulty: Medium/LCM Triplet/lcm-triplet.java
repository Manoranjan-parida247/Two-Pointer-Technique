class Solution {
    int lcmTriplets(int n) {
        if (n <= 2) return n;

        long res;

        if (n % 2 != 0) {
            // If n is odd => take n, n-1, n-2
            res = (long) n * (n - 1) * (n - 2);
        } else {
            if (n % 3 != 0) {
                // If even but not divisible by 3 => take n, n-1, n-3
                res = (long) n * (n - 1) * (n - 3);
            } else {
                // If even and divisible by 3 => take n-1, n-2, n-3
                res = (long) (n - 1) * (n - 2) * (n - 3);
            }
        }

        return (int) res;
    }
}
