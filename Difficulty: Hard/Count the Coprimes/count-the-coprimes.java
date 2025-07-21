

class Solution {
    static final int MAX = 10001;

    int cntCoprime(int[] arr) {
        int n = arr.length;
        int[] freq = new int[MAX];

        for (int num : arr) {
            freq[num]++;
        }

        // Count of numbers divisible by i
        int[] divCount = new int[MAX];
        for (int i = 1; i < MAX; i++) {
            for (int j = i; j < MAX; j += i) {
                divCount[i] += freq[j];
            }
        }

        // Mobius function
        int[] mobius = new int[MAX];
        Arrays.fill(mobius, 1);
        for (int i = 2; i < MAX; i++) {
            for (int j = 2 * i; j < MAX; j += i) {
                mobius[j] -= mobius[i];
            }
        }

        long totalPairs = (1L * n * (n - 1)) / 2;
        long nonCoprimePairs = 0;

        for (int i = 2; i < MAX; i++) {
            long cnt = divCount[i];
            long pairs = (cnt * (cnt - 1)) / 2;
            nonCoprimePairs += mobius[i] * pairs;
        }

        return (int) (totalPairs - nonCoprimePairs);
    }
}
