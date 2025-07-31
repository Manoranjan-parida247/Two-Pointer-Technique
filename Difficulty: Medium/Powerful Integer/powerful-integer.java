

class Solution {
    public int powerfulInteger(int[][] intervals, int k) {
        TreeMap<Integer, Integer> map = new TreeMap<>();

        // Mark +1 at start and -1 at end+1
        for (int[] interval : intervals) {
            int start = interval[0], end = interval[1];
            map.put(start, map.getOrDefault(start, 0) + 1);
            map.put(end + 1, map.getOrDefault(end + 1, 0) - 1);
        }

        int currentCount = 0;
        int lastPosition = -1;
        int maxPowerful = -1;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int position = entry.getKey();
            int change = entry.getValue();

            // If current count is >= k, then all numbers from lastPosition to position-1 are powerful
            if (currentCount >= k && lastPosition != -1) {
                maxPowerful = Math.max(maxPowerful, position - 1);
            }

            currentCount += change;
            lastPosition = position;
        }

        return maxPowerful;
    }
}
