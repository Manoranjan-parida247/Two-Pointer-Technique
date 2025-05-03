//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String str = br.readLine();

            Solution obj = new Solution();
            System.out.println(obj.findSubString(str));

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int findSubString(String str) {
        // code here
        // Step 1: Count all unique characters in the string
        HashSet<Character> uniqueChars = new HashSet<>();
        for (char ch : str.toCharArray()) {
            uniqueChars.add(ch);
        }
        int required = uniqueChars.size();

        // Step 2: Sliding window variables
        HashMap<Character, Integer> windowCounts = new HashMap<>();
        int left = 0, right = 0, formed = 0;
        int minLength = Integer.MAX_VALUE;

        while (right < str.length()) {
            char ch = str.charAt(right);
            windowCounts.put(ch, windowCounts.getOrDefault(ch, 0) + 1);

            // If this char's count becomes 1 for the first time, increment formed
            if (windowCounts.get(ch) == 1) {
                formed++;
            }

            // Try shrinking the window from left
            while (formed == required) {
                minLength = Math.min(minLength, right - left + 1);

                char leftChar = str.charAt(left);
                windowCounts.put(leftChar, windowCounts.get(leftChar) - 1);
                if (windowCounts.get(leftChar) == 0) {
                    formed--;
                }
                left++;
            }

            right++;
        }

        return minLength;
    }
}