//{ Driver Code Starts
// Initial Template for Java

import java.math.*;
import java.util.*;

class Multiply {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String a = sc.next();
            String b = sc.next();
            Solution g = new Solution();
            System.out.println(g.multiplyStrings(a, b));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public static String multiplyStrings(String s1, String s2) {
        // Handle null or empty strings
        if (s1 == null || s2 == null || s1.length() == 0 || s2.length() == 0) return "0";

        // Determine the sign
        boolean negative = false;
        if (s1.charAt(0) == '-') {
            negative = !negative;
            s1 = s1.substring(1);
        }
        if (s2.charAt(0) == '-') {
            negative = !negative;
            s2 = s2.substring(1);
        }

        // Remove leading zeros
        s1 = removeLeadingZeros(s1);
        s2 = removeLeadingZeros(s2);

        // If any string is "0" after removing leading zeros
        if (s1.equals("0") || s2.equals("0")) {
            return "0";
        }

        int n = s1.length();
        int m = s2.length();
        int[] result = new int[n + m];

        // Multiply each digit
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                int mul = (s1.charAt(i) - '0') * (s2.charAt(j) - '0');
                int sum = mul + result[i + j + 1];

                result[i + j + 1] = sum % 10;
                result[i + j] += sum / 10;
            }
        }

        // Build the result string
        StringBuilder sb = new StringBuilder();
        for (int num : result) {
            if (sb.length() == 0 && num == 0) continue; // Skip leading zeros
            sb.append(num);
        }

        // Add negative sign if needed
        if (negative) {
            sb.insert(0, '-');
        }

        return sb.toString();
    }

    private static String removeLeadingZeros(String s) {
        int i = 0;
        while (i < s.length() && s.charAt(i) == '0') {
            i++;
        }
        return (i == s.length()) ? "0" : s.substring(i);
    }
}
