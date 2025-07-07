

class Solution {
    // Returns an ArrayList containing the next greater element for every index
    public ArrayList<Integer> nextLargerElement(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();      // stores indices
       
        // initialise answer array with -1
        for (int i = 0; i < n; i++) ans[i] = -1;

        // Traverse 2n-1 .. 0 to simulate circular array
        for (int i = 2 * n - 1; i >= 0; i--) {
            int idx = i % n;

            // Pop elements ≤ current value
            while (!st.isEmpty() && arr[st.peek()] <= arr[idx]) {
                st.pop();
            }

            // If stack isn’t empty, its top is the next greater element
            if (!st.isEmpty()) {
                ans[idx] = arr[st.peek()];
            }

            // Push current index for future comparisons
            st.push(idx);
        }

        // Convert to ArrayList as required
        ArrayList<Integer> res = new ArrayList<>(n);
        for (int x : ans) res.add(x);
        return res;
    }
}
