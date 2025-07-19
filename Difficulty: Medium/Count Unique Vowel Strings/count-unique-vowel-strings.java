

class Solution {
    public int vowelCount(String s) {
        // Set of vowels
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        Map<Character, Integer> freq = new HashMap<>();

        // Count frequencies of vowels
        for (char c : s.toCharArray()) {
            if (vowels.contains(c)) {
                freq.put(c, freq.getOrDefault(c, 0) + 1);
            }
        }

        int k = freq.size(); // number of unique vowels
        if (k == 0) return 0;

        // Product of choosing one occurrence per vowel
        long selectionWays = 1;
        for (int count : freq.values()) {
            selectionWays *= count;
        }

        // k! = number of permutations of k selected vowels
        long factorial = 1;
        for (int i = 2; i <= k; i++) {
            factorial *= i;
        }

        long result = selectionWays * factorial;
        return (int) result;  // Fits in int since input constraints are small
    }
}
