class Solution {
    public static int sumSubstrings(String s) {
        int n = s.length();
        long res = 0, prev = 0;
        int mod = 1000000007; // if needed, though constraints say 32-bit int is safe

        for (int i = 0; i < n; i++) {
            int num = s.charAt(i) - '0';
            long curr = (prev * 10) + num * (i + 1);
            res += curr;
            prev = curr;
        }

        return (int)res; // guaranteed to be in 32-bit range
    }
}
