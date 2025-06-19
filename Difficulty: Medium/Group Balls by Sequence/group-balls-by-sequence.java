class Solution {
    public boolean validgroup(int[] arr, int k) {
        // code here
        if (arr.length % k != 0) return false;
        TreeMap<Integer, Integer> count = new TreeMap<>();
        for (int num : arr) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        while (!count.isEmpty()) {
            int first = count.firstKey();
            int freq = count.get(first);
            for (int i = 0; i < k; i++) {
                int curr = first + i;
                if (!count.containsKey(curr) || count.get(curr) < freq) {
                    return false;
                }
                if (count.get(curr) == freq) {
                    count.remove(curr);
                } else {
                    count.put(curr, count.get(curr) - freq);
                }
            }
        }
        return true;
    }
}