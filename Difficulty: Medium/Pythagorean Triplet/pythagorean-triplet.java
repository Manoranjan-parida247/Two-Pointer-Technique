// import java.util.HashSet;

class Solution {
    boolean pythagoreanTriplet(int[] arr) {
        int n = arr.length;

        // Step 1: Create a set of all squares
        HashSet<Integer> squareSet = new HashSet<>();
        for (int num : arr) {
            squareSet.add(num * num);
        }

        // Step 2: Try every pair (a, b), and check if (a^2 + b^2) exists in the set
        for (int i = 0; i < n; i++) {
            int a2 = arr[i] * arr[i];
            for (int j = i + 1; j < n; j++) {
                int b2 = arr[j] * arr[j];
                int sum = a2 + b2;

                if (squareSet.contains(sum)) {
                    return true;
                }
            }
        }

        return false;
    }
}
