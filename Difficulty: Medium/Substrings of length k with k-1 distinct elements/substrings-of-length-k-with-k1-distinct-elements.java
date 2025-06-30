class Solution {
    public int substrCount(String s, int k) {
        if (s.length() < k) return 0;

        int count = 0;
        Map<Character, Integer> freq = new HashMap<>();

        // First window
        for (int i = 0; i < k; i++) {
            freq.put(s.charAt(i), freq.getOrDefault(s.charAt(i), 0) + 1);
        }

        if (freq.size() == k - 1) count++;

        // Slide window
        for (int i = k; i < s.length(); i++) {
            char out = s.charAt(i - k);   // character going out
            char in = s.charAt(i);        // character coming in

            // Remove outgoing char
            freq.put(out, freq.get(out) - 1);
            if (freq.get(out) == 0) freq.remove(out);

            // Add incoming char
            freq.put(in, freq.getOrDefault(in, 0) + 1);

            if (freq.size() == k - 1) count++;
        }

        return count;
    }
}
