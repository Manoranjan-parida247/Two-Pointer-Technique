
class Solution {
    public int longestCommonSum(int[] a1, int[] a2) {
        int n = a1.length;
        int[] diff = new int[n];
        
        // Initialize map to store first occurrence of difference
        Map<Integer, Integer> map = new HashMap<>();
        
        int maxLen = 0;
        int preSum1 = 0, preSum2 = 0;
        
        for (int i = 0; i < n; i++) {
            preSum1 += a1[i];
            preSum2 += a2[i];
            
            int currDiff = preSum1 - preSum2;
            
            if (currDiff == 0) {
                maxLen = i + 1; // entire prefix has equal sum
            } else if (map.containsKey(currDiff)) {
                int prevIndex = map.get(currDiff);
                maxLen = Math.max(maxLen, i - prevIndex);
            } else {
                map.put(currDiff, i); // store first occurrence
            }
        }
        return maxLen;
    }
}
