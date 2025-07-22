class Solution {
    public int missingNumber(int[] arr) {
        int n = arr.length;

        // Step 1: Place each number at its correct position
        for (int i = 0; i < n; i++) {
            while (
                arr[i] > 0 && arr[i] <= n && 
                arr[arr[i] - 1] != arr[i]
            ) {
                // Swap arr[i] with arr[arr[i] - 1]
                int correctIdx = arr[i] - 1;
                int temp = arr[i];
                arr[i] = arr[correctIdx];
                arr[correctIdx] = temp;
            }
        }

        // Step 2: Find the first index where arr[i] != i+1
        for (int i = 0; i < n; i++) {
            if (arr[i] != i + 1) {
                return i + 1;
            }
        }

        // If all values from 1 to n are present
        return n + 1;
    }
}
