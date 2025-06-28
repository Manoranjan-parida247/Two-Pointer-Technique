class Solution {
    public int splitArray(int[] arr, int k) {
        int low = getMax(arr);        // smallest possible max sum
        int high = getSum(arr);       // largest possible max sum

        int answer = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canSplit(arr, k, mid)) {
                answer = mid;         // try smaller maximum
                high = mid - 1;
            } else {
                low = mid + 1;        // need to allow bigger subarray sum
            }
        }

        return answer;
    }

    private int getMax(int[] arr) {
        int max = arr[0];
        for (int val : arr) {
            if (val > max) max = val;
        }
        return max;
    }

    private int getSum(int[] arr) {
        int sum = 0;
        for (int val : arr) sum += val;
        return sum;
    }

    private boolean canSplit(int[] arr, int k, int maxAllowedSum) {
        int count = 1;     // at least one subarray
        int currentSum = 0;

        for (int val : arr) {
            if (currentSum + val > maxAllowedSum) {
                count++;              // start a new subarray
                currentSum = val;
                if (count > k) return false;
            } else {
                currentSum += val;
            }
        }

        return true;
    }
}
