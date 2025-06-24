
class Solution {
    boolean sameFreq(String s) {
        // Step 1: Count frequency of each character
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        // Step 2: Count frequencies of the frequencies
        Map<Integer, Integer> countFreq = new HashMap<>();
        for (int freq : freqMap.values()) {
            countFreq.put(freq, countFreq.getOrDefault(freq, 0) + 1);
        }

        // If all frequencies are same
        if (countFreq.size() == 1) return true;

        // If more than 2 different frequencies, can't fix with one removal
        if (countFreq.size() > 2) return false;

        // Extract frequencies
        List<Integer> keys = new ArrayList<>(countFreq.keySet());
        int f1 = keys.get(0), f2 = keys.get(1);
        int c1 = countFreq.get(f1), c2 = countFreq.get(f2);

        // Check valid conditions
        if ((f1 == 1 && c1 == 1) || (f2 == 1 && c2 == 1)) return true;

        if ((Math.abs(f1 - f2) == 1) && ((f1 > f2 && c1 == 1) || (f2 > f1 && c2 == 1))) return true;

        return false;
    }
}
