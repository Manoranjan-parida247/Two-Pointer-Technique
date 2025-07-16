class Solution {
    public static int countNumbers(int n) {
        int limit = (int)Math.sqrt(n) + 1;

        // Step 1: Sieve of Eratosthenes to generate all primes up to sqrt(n)
        boolean[] isPrime = new boolean[limit];
        for (int i = 2; i < limit; i++) {
            isPrime[i] = true;
        }

        for (int i = 2; i * i < limit; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < limit; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        // Collect all primes
        java.util.List<Integer> primes = new java.util.ArrayList<>();
        for (int i = 2; i < limit; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }

        int count = 0;

        // Step 2: Count numbers of the form p^8 <= n
        for (int p : primes) {
            long val = 1L * p * p * p * p * p * p * p * p;
            if (val <= n) {
                count++;
            } else {
                break;
            }
        }

        // Step 3: Count numbers of the form p^2 * q^2 <= n, where p != q
        int size = primes.size();
        for (int i = 0; i < size; i++) {
            int p = primes.get(i);
            long p2 = 1L * p * p;
            if (p2 > n) break;
            for (int j = i + 1; j < size; j++) {
                int q = primes.get(j);
                long q2 = 1L * q * q;
                if (p2 * q2 <= n) {
                    count++;
                } else {
                    break;
                }
            }
        }

        return count;
    }
}
