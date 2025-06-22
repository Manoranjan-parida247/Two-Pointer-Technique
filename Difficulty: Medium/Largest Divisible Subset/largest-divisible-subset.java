

class Solution {
    public ArrayList<Integer> largestSubset(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr); // Step 1: Sort the array

        int[] dp = new int[n]; // dp[i] = length of largest subset ending at i
        int[] prev = new int[n]; // prev[i] = previous index in subset

        Arrays.fill(dp, 1);
        for (int i = 0; i < n; i++) prev[i] = -1;

        int maxLen = 1;
        int lastIndex = 0;

        // Step 2: Fill dp and prev arrays
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] % arr[j] == 0 && dp[j] + 1 >= dp[i]) {
                    if (dp[j] + 1 > dp[i] || (dp[j] + 1 == dp[i] && isLexGreater(arr, j, prev, arr[i], i))) {
                        dp[i] = dp[j] + 1;
                        prev[i] = j;
                    }
                }
            }
            if (dp[i] > maxLen || (dp[i] == maxLen && isLexGreater(arr, i, prev, arr[lastIndex], lastIndex))) {
                maxLen = dp[i];
                lastIndex = i;
            }
        }

        // Step 3: Reconstruct the subset
        ArrayList<Integer> subset = new ArrayList<>();
        int idx = lastIndex;
        while (idx != -1) {
            subset.add(arr[idx]);
            idx = prev[idx];
        }

        Collections.sort(subset); // sort to make it ascending

        return subset;
    }

    // Function to compare two potential subsets for lexicographical greatness
    private boolean isLexGreater(int[] arr, int i, int[] prev, int x, int y) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        
        while (i != -1) {
            list1.add(arr[i]);
            i = prev[i];
        }

        while (y != -1) {
            list2.add(arr[y]);
            y = prev[y];
        }

        Collections.sort(list1);
        Collections.sort(list2);
        
        for (int j = 0; j < Math.min(list1.size(), list2.size()); j++) {
            if (!list1.get(j).equals(list2.get(j))) {
                return list1.get(j) > list2.get(j);
            }
        }
        return list1.size() > list2.size();
    }
}
