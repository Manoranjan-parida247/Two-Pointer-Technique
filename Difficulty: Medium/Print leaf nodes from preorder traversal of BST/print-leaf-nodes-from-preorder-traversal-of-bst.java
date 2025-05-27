// import java.util.*;

class Solution {
    int index = 0;
    public ArrayList<Integer> leafNodes(int[] preorder) {
        ArrayList<Integer> leaves = new ArrayList<>();
        constructLeaves(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE, leaves);
        return leaves;
    }

    private void constructLeaves(int[] preorder, int min, int max, ArrayList<Integer> leaves) {
        if (index >= preorder.length) return;

        int val = preorder[index];

        // Not in current subtree range
        if (val < min || val > max) return;

        index++;

        // Before and after recursive calls, record index
        int beforeLeft = index;
        constructLeaves(preorder, min, val, leaves);
        int afterLeft = index;

        constructLeaves(preorder, val, max, leaves);
        int afterRight = index;

        // If index didn't change in either call, it's a leaf
        if (beforeLeft == afterLeft && afterLeft == afterRight) {
            leaves.add(val);
        }
    }
}
