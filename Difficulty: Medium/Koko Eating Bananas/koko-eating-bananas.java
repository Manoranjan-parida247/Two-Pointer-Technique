class Solution {
    public int kokoEat(int[] arr, int k) {
        int left = 1;
        int right = 0;
        for (int bananas : arr) {
            right = Math.max(right, bananas);
        }

        int result = right;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (canFinish(arr, k, mid)) {
                result = mid;       // try to minimize s
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return result;
    }

    private boolean canFinish(int[] arr, int k, int s) {
        int totalHours = 0;

        for (int bananas : arr) {
            totalHours += (bananas + s - 1) / s; // same as ceil(bananas / s)
        }

        return totalHours <= k;
    }
}
