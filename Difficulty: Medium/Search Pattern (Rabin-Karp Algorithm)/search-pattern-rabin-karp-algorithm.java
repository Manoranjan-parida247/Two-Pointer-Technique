class Solution {
    ArrayList<Integer> search(String pat, String txt) {
        ArrayList<Integer> result = new ArrayList<>();
        
        int d = 256; // base (number of possible characters)
        int q = 101; // a prime number for modulus to reduce collisions
        int M = pat.length();
        int N = txt.length();
        
        int p = 0; // hash value for pattern
        int t = 0; // hash value for text
        int h = 1;
        
        // The value of h would be "pow(d, M-1)%q"
        for (int i = 0; i < M - 1; i++) {
            h = (h * d) % q;
        }
        
        // Calculate the hash value of pattern and first window of text
        for (int i = 0; i < M; i++) {
            p = (d * p + pat.charAt(i)) % q;
            t = (d * t + txt.charAt(i)) % q;
        }
        
        // Slide the pattern over text one by one
        for (int i = 0; i <= N - M; i++) {
            // Check the hash values of current window of text and pattern
            if (p == t) {
                // Check for characters one by one (to handle hash collision)
                int j = 0;
                while (j < M && txt.charAt(i + j) == pat.charAt(j)) {
                    j++;
                }
                if (j == M) {
                    result.add(i + 1); // 1-based indexing
                }
            }
            
            // Calculate hash value for next window of text:
            if (i < N - M) {
                t = (d * (t - txt.charAt(i) * h) + txt.charAt(i + M)) % q;
                
                // We might get negative value of t, converting it to positive
                if (t < 0)
                    t = (t + q);
            }
        }
        
        return result;
    }
}
