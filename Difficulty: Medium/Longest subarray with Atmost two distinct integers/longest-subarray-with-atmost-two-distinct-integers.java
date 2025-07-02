

class Solution {
    public int totalElements(int[] arr) {
        int left = 0, maxLen = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int right = 0; right < arr.length; right++) {
            // Add current element to the map
            map.put(arr[right], map.getOrDefault(arr[right], 0) + 1);

            // If map has more than 2 distinct elements, shrink window from left
            while (map.size() > 2) {
                map.put(arr[left], map.get(arr[left]) - 1);
                if (map.get(arr[left]) == 0) {
                    map.remove(arr[left]);
                }
                left++;
            }

            // Update maximum length
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}
