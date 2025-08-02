

class Solution {
    public int longestSubarray(int[] arr, int k) {
        int n = arr.length;
        int maxLen = 0;
        int prefixSum = 0;

        // Map to store the first occurrence of each prefix sum
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            // Convert elements: > k → +1, else → -1
            int val = arr[i] > k ? 1 : -1;
            prefixSum += val;

            // If prefix sum is positive, whole array from 0 to i is valid
            if (prefixSum > 0) {
                maxLen = i + 1;
            }

            // Store the first occurrence of prefixSum
            if (!map.containsKey(prefixSum)) {
                map.put(prefixSum, i);
            }

            // Check if prefixSum - 1 exists to form a positive sum subarray
            if (map.containsKey(prefixSum - 1)) {
                int prevIndex = map.get(prefixSum - 1);
                maxLen = Math.max(maxLen, i - prevIndex);
            }
        }

        return maxLen;
    }
}
