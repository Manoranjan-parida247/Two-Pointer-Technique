//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String S = br.readLine().trim();
            Solution obj = new Solution();
            ArrayList<String> ans = obj.findPermutation(S);
            Collections.sort(ans);
            for (int i = 0; i < ans.size(); i++) {
                out.print(ans.get(i) + " ");
            }
            out.println();

            out.println("~");
        }
        out.close();
    }
}

// } Driver Code Ends


class Solution {
    public ArrayList<String> findPermutation(String s) {
        // Code here
        Set<String> st = new HashSet<>();
        StringBuilder permu = new StringBuilder();
        StringBuilder strBuilder = new StringBuilder(s);
        int n = s.length();

        solve(0, n, strBuilder, permu, st);

        // Convert the set to a list and return
        return new ArrayList<>(st);
    }
    
    private void solve(int i, int n, StringBuilder s, StringBuilder permu, Set<String> st) {
        if (permu.length() == n) {
            st.add(permu.toString());
            return;
        }

        for (int j = i; j < n; j++) {
            // Swap characters at indices i and j
            char temp = s.charAt(i);
            s.setCharAt(i, s.charAt(j));
            s.setCharAt(j, temp);

            permu.append(s.charAt(i));
            solve(i + 1, n, s, permu, st);
            permu.deleteCharAt(permu.length() - 1);

            // Swap back to restore original state
            temp = s.charAt(i);
            s.setCharAt(i, s.charAt(j));
            s.setCharAt(j, temp);
        }
    }
}