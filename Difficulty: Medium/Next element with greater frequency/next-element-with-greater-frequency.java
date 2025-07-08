

class Solution {
    public ArrayList<Integer> findGreater(int[] arr) {
        int n = arr.length;
        HashMap<Integer, Integer> freq = new HashMap<>();
        ArrayList<Integer> result = new ArrayList<>(Collections.nCopies(n, -1));
        Stack<Integer> stack = new Stack<>();

        // Step 1: Build frequency map
        for (int num : arr) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        // Step 2: Traverse from right to left
        for (int i = n - 1; i >= 0; i--) {
            int curr = arr[i];

            // Remove elements from stack with frequency <= current
            while (!stack.isEmpty() && freq.get(stack.peek()) <= freq.get(curr)) {
                stack.pop();
            }

            // If stack is not empty, that is the next greater frequency element
            if (!stack.isEmpty()) {
                result.set(i, stack.peek());
            }

            // Push current element onto stack
            stack.push(curr);
        }

        return result;
    }
}
