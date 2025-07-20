

class Solution {
    public int countValid(int n, int[] arr) {
        Set<Integer> forbidden = new HashSet<>();
        for (int digit : arr) {
            forbidden.add(digit);
        }

        // Allowed digits = digits not in arr[]
        List<Integer> allowedDigits = new ArrayList<>();
        for (int i = 0; i <= 9; i++) {
            if (!forbidden.contains(i)) {
                allowedDigits.add(i);
            }
        }

        int total = 9 * (int)Math.pow(10, n - 1); // Total n-digit numbers

        // If no allowed digits, then all numbers contain at least one digit from arr[]
        if (allowedDigits.isEmpty()) {
            return total;
        }

        // Count "bad" numbers = n-digit numbers formed using only allowedDigits
        int bad = 0;
        int d = allowedDigits.size();

        for (int i = 0; i < d; i++) {
            int first = allowedDigits.get(i);
            if (first == 0) continue; // Can't start with 0

            bad += countCombinations(first, allowedDigits, n - 1);
        }

        return total - bad;
    }

    private int countCombinations(int firstDigit, List<Integer> allowed, int remainingDigits) {
        int base = allowed.size();
        return (int)Math.pow(base, remainingDigits);
    }
}
