//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends

// User function template for C++
class Trie {
  public:
  
  bool end;
  vector<Trie*>children;

    Trie() {
        // implement Trie
        end=false;
        children.resize(26, NULL);
    }

    void insert(string &word) {
        // insert word into Trie
        Trie * root= this;
        for(auto it:word){
            int idx=it-'a';
            if(!root->children[idx]){
                root->children[idx]= new Trie();
            }
            root=root->children[idx];
        }
        root->end=true;
    }

    bool search(string &word) {
        // search word in the Trie
        Trie* root=this;
        for(auto it:word){
            int idx=it-'a';
            if(!root->children[idx]){
                return false;
            }
            root=root->children[idx];
        }
        return root->end;
        
    }

    bool isPrefix(string &word) {
        // search prefix word in the Trie
        Trie* root=this;
        for(auto it:word){
            int idx=it-'a';
            if(!root->children[idx]){
                return false;
            }
            root=root->children[idx];
        }
        return true;
    }
};



//{ Driver Code Starts.

int main() {
    int t;
    cin >> t;
    cin.ignore();
    while (t--) {
        int q;
        cin >> q;
        cin.ignore();
        vector<bool> ans;
        Trie ob;
        for (int i = 0; i < q; i++) {
            int x;
            cin >> x;
            string s;
            cin >> s;
            cin.ignore();
            if (x == 1) {
                ob.insert(s);
            } else if (x == 2) {
                ans.push_back(ob.search(s));
            } else if (x == 3) {
                ans.push_back(ob.isPrefix(s));
            }
        }
        cout << boolalpha;
        for (auto it : ans) {
            cout << it << " ";
        }
        cout << endl;
        cout << "~\n";
    }
    return 0;
}

// } Driver Code Ends