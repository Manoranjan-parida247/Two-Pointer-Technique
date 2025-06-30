class Solution {
    public int maxMinHeight(int[] arr, int k, int w) {
        int n = arr.length;
        int low = Arrays.stream(arr).min().getAsInt();
        int high = low + k;

        int ans = low;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canReachHeight(arr, n, k, w, mid)) {
                ans = mid;
                low = mid + 1; // Try higher
            } else {
                high = mid - 1; // Try lower
            }
        }

        return ans;
    }

    private boolean canReachHeight(int[] arr, int n, int k, int w, int target) {
        int[] diff = new int[n + w + 1]; // Difference array
        long ops = 0;
        long water = 0;

        for (int i = 0; i < n; i++) {
            water += diff[i];

            int current = arr[i] + (int)water;

            if (current < target) {
                int need = target - current;
                ops += need;

                if (ops > k) return false;

                water += need;
                diff[i + w] -= need;
            }
        }

        return true;
    }
}
