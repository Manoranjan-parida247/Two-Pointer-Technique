

class Solution {
    public ArrayList<Integer> asciirange(String s) {
        int n = s.length();
        Map<Character, int[]> positions = new HashMap<>();

        // Store first and last positions of each character
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (!positions.containsKey(ch)) {
                positions.put(ch, new int[]{i, i}); // [first, last]
            } else {
                positions.get(ch)[1] = i;
            }
        }

        ArrayList<Integer> result = new ArrayList<>();

        for (Map.Entry<Character, int[]> entry : positions.entrySet()) {
            int first = entry.getValue()[0];
            int last = entry.getValue()[1];
            if (last > first + 1) {
                int sum = 0;
                for (int i = first + 1; i < last; i++) {
                    sum += (int) s.charAt(i);
                }
                if (sum > 0) result.add(sum);
            }
        }

        return result;
    }
}
