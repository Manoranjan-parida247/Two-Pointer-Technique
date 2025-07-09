

class Solution {
    public int sumSubMins(int[] arr) {
        int MOD = (int)1e9 + 7;
        int n = arr.length;

        Stack<Integer> stack = new Stack<>();

        int[] ple = new int[n]; // Previous Less Element
        int[] nle = new int[n]; // Next Less Element

        // PLE: nearest less element to the left
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            ple[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        // Clear stack for NLE
        stack.clear();

        // NLE: nearest less element to the right
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            nle[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        long result = 0;
        for (int i = 0; i < n; i++) {
            long left = i - ple[i];
            long right = nle[i] - i;
            result = (result + (arr[i] * left * right) % MOD) % MOD;
        }

        return (int)result;
    }
}

