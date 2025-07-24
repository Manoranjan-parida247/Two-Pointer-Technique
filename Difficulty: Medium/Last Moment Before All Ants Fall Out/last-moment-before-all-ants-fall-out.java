class Solution {
    public int getLastMoment(int n, int left[], int right[]) {
        int maxTime = 0;
        
        // Find max time for left-moving ants
        for (int pos : left) {
            maxTime = Math.max(maxTime, pos); // takes 'pos' seconds to fall off
        }
        
        // Find max time for right-moving ants
        for (int pos : right) {
            maxTime = Math.max(maxTime, n - pos); // takes 'n - pos' seconds to fall off
        }
        
        return maxTime;
    }
}
