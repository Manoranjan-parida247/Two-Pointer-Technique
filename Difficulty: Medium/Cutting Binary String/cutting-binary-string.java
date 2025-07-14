

class Solution {
    private Set<String> powerOf5Set;

    public int cuts(String s) {
        int n = s.length();
        powerOf5Set = generatePowerOf5UpToLength(n);

        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0; // Empty prefix has 0 cuts

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                String sub = s.substring(j, i);
                if (isValid(sub)) {
                    if (dp[j] != Integer.MAX_VALUE) {
                        dp[i] = Math.min(dp[i], dp[j] + 1);
                    }
                }
            }
        }

        return dp[n] == Integer.MAX_VALUE ? -1 : dp[n];
    }

    private boolean isValid(String sub) {
        return !sub.startsWith("0") && powerOf5Set.contains(sub);
    }

    private Set<String> generatePowerOf5UpToLength(int maxLength) {
        Set<String> set = new HashSet<>();
        long num = 1;
        while (true) {
            String binary = Long.toBinaryString(num);
            if (binary.length() > maxLength) break;
            set.add(binary);
            num *= 5;
        }
        return set;
    }
}

