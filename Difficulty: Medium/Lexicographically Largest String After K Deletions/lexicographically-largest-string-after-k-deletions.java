class Solution {
    public static String maxSubseq(String s, int k) {
        int n = s.length();
        int keep = n - k;
        StringBuilder stack = new StringBuilder();

        for (char c : s.toCharArray()) {
            while (stack.length() > 0 && k > 0 && stack.charAt(stack.length() - 1) < c) {
                stack.deleteCharAt(stack.length() - 1);
                k--;
            }
            stack.append(c);
        }

        // We only need the first 'keep' characters
        return stack.substring(0, keep);
    }
}
