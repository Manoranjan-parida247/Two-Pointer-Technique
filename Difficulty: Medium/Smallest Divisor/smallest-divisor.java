class Solution {
    int smallestDivisor(int[] arr, int k) {
        int low = 1;
        int high = getMax(arr);
        int ans = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (isValid(arr, k, mid)) {
                ans = mid; // possible answer, try smaller
                high = mid - 1;
            } else {
                low = mid + 1; // need bigger divisor
            }
        }

        return ans;
    }

    // Helper to check if a given divisor gives sum <= k
    private boolean isValid(int[] arr, int k, int divisor) {
        int sum = 0;
        for (int num : arr) {
            sum += (num + divisor - 1) / divisor;  // ceil(num / divisor)
        }
        return sum <= k;
    }

    // Helper to get max element in array
    private int getMax(int[] arr) {
        int max = arr[0];
        for (int num : arr) {
            if (num > max) max = num;
        }
        return max;
    }
}
