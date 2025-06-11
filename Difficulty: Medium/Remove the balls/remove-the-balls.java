

class Solution {
    public int findLength(int[] color, int[] radius) {
        Deque<int[]> stack = new ArrayDeque<>();

        for (int i = 0; i < color.length; i++) {
            int c = color[i];
            int r = radius[i];

            if (!stack.isEmpty() && stack.peek()[0] == c && stack.peek()[1] == r) {
                stack.pop(); // remove the matching pair
            } else {
                stack.push(new int[]{c, r});
            }
        }

        return stack.size(); // remaining balls
    }
}
