//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends



class Solution {
  public:
    string maxNum;

    void helper(string& s, int k, int idx) {
        if (k == 0 || idx == s.size()) return;

        char maxDigit = s[idx];
        for (int i = idx + 1; i < s.size(); i++) {
            if (s[i] > maxDigit)
                maxDigit = s[i];
        }

        // If the current digit is already max, we don't reduce k
        if (maxDigit != s[idx]) k--;

        for (int i = s.size() - 1; i >= idx; i--) {
            if (s[i] == maxDigit) {
                swap(s[i], s[idx]);
                if (s.compare(maxNum) > 0)
                    maxNum = s;
                helper(s, k, idx + 1);
                swap(s[i], s[idx]); // backtrack
            }
        }
    }

    string findMaximumNum(string& s, int k) {
        maxNum = s;
        helper(s, k, 0);
        return maxNum;
    }
};



//{ Driver Code Starts.

int main() {
    int t, k;
    string str;

    cin >> t;
    while (t--) {
        cin >> k >> str;
        Solution ob;
        cout << ob.findMaximumNum(str, k) << endl;

        cout << "~"
             << "\n";
    }
    return 0;
}

// } Driver Code Ends