// User function Template for Java

// import java.util.*;

class Solution {
    int countSubstr(String s, int k) {
        return countAtMostK(s, k) - countAtMostK(s, k - 1);
    }

    private int countAtMostK(String s, int k) {
        if (k == 0) return 0;

        int left = 0, right = 0;
        int n = s.length();
        int result = 0;
        Map<Character, Integer> freqMap = new HashMap<>();

        for (right = 0; right < n; right++) {
            char rightChar = s.charAt(right);
            freqMap.put(rightChar, freqMap.getOrDefault(rightChar, 0) + 1);

            // Shrink window if distinct chars exceed k
            while (freqMap.size() > k) {
                char leftChar = s.charAt(left);
                freqMap.put(leftChar, freqMap.get(leftChar) - 1);
                if (freqMap.get(leftChar) == 0) {
                    freqMap.remove(leftChar);
                }
                left++;
            }

            result += (right - left + 1);
        }

        return result;
    }
}
