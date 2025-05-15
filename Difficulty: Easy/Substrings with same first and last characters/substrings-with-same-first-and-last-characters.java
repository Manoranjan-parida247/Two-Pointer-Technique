//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String s = read.readLine();

            Solution ob = new Solution();
            int result = ob.countSubstring(s);

            System.out.println(result);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public int countSubstring(String s) {
        // code here
        int[] freq = new int[26];
        int result = 0;

        // Count frequency of each character
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        // For each character, calculate count of substrings
        for (int f : freq) {
            if (f > 0) {
                result += (f * (f - 1)) / 2;  // substrings of length >= 2
                result += f;                 // substrings of length 1
            }
        }

        return result;
    }
}