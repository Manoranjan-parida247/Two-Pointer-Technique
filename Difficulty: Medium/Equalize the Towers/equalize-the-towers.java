

class Solution {
    public int minCost(int[] heights, int[] cost) {
        int n = heights.length;
        int[][] towers = new int[n][2];  // {height, cost}

        for (int i = 0; i < n; i++) {
            towers[i][0] = heights[i];
            towers[i][1] = cost[i];
        }

        // Sort by height
        Arrays.sort(towers, Comparator.comparingInt(a -> a[0]));

        // Total weight
        long totalCost = 0;
        for (int[] tower : towers) {
            totalCost += tower[1];
        }

        // Find weighted median
        long prefixSum = 0;
        int medianHeight = 0;
        for (int[] tower : towers) {
            prefixSum += tower[1];
            if (prefixSum >= (totalCost + 1) / 2) {
                medianHeight = tower[0];
                break;
            }
        }

        // Calculate total cost to make all towers of medianHeight
        int minTotalCost = 0;
        for (int i = 0; i < n; i++) {
            minTotalCost += Math.abs(heights[i] - medianHeight) * cost[i];
        }

        return minTotalCost;
    }
}

