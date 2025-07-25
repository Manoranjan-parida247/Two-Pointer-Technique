class Solution {
    public int maxCircularSum(int arr[]) {
        int n = arr.length;

        // Step 1: Find normal max subarray sum using Kadane’s Algorithm
        int maxKadane = kadane(arr);

        // Step 2: Find total sum of array
        int totalSum = 0;
        for (int num : arr) {
            totalSum += num;
        }

        // Step 3: Invert the sign of array elements to use Kadane's for min subarray sum
        int[] invertedArr = new int[n];
        for (int i = 0; i < n; i++) {
            invertedArr[i] = -arr[i];
        }

        // Step 4: Find minimum subarray sum = -kadane(invertedArr)
        int maxInvertedKadane = kadane(invertedArr);
        int minSubarraySum = -maxInvertedKadane;

        // Step 5: Handle case where all numbers are negative
        if (totalSum == minSubarraySum) {
            return maxKadane;
        }

        // Step 6: Return the maximum of non-wrapping and wrapping subarray sums
        return Math.max(maxKadane, totalSum - minSubarraySum);
    }

    private int kadane(int[] arr) {
        int maxSoFar = arr[0];
        int currMax = arr[0];
        for (int i = 1; i < arr.length; i++) {
            currMax = Math.max(arr[i], currMax + arr[i]);
            maxSoFar = Math.max(maxSoFar, currMax);
        }
        return maxSoFar;
    }
}
