// import java.util.*;

class Solution {
    public int countAtMostK(int[] arr, int k) {
        if (k == 0) return 0;

        Map<Integer, Integer> map = new HashMap<>();
        int start = 0, result = 0;

        for (int end = 0; end < arr.length; end++) {
            map.put(arr[end], map.getOrDefault(arr[end], 0) + 1);

            while (map.size() > k) {
                map.put(arr[start], map.get(arr[start]) - 1);
                if (map.get(arr[start]) == 0) {
                    map.remove(arr[start]);
                }
                start++;
            }

            result += end - start + 1;
        }

        return result;
    }

    public int subarraysWithAtMostKDistinct(int[] arr, int k) {
        return countAtMostK(arr, k);
    }
}

