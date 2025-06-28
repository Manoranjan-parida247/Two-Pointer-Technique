

class Solution {
    public static ArrayList<Integer> countLessEq(int a[], int b[]) {
        ArrayList<Integer> result = new ArrayList<>();
        
        // Step 1: Sort array b
        Arrays.sort(b);
        
        // Step 2: For each element in a, binary search on b
        for (int val : a) {
            int count = countLessThanOrEqual(b, val);
            result.add(count);
        }
        
        return result;
    }

    // Custom binary search to find number of elements <= key
    private static int countLessThanOrEqual(int[] b, int key) {
        int low = 0, high = b.length - 1, ans = -1;
        
        while (low <= high) {
            int mid = (low + high) / 2;
            
            if (b[mid] <= key) {
                ans = mid; // possible answer
                low = mid + 1; // search right
            } else {
                high = mid - 1; // search left
            }
        }
        
        return ans + 1; // index + 1 gives count
    }
}
