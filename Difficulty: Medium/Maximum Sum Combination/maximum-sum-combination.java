

class Solution {
    public ArrayList<Integer> topKSumPairs(int[] a, int[] b, int k) {
        int n = a.length;
        Arrays.sort(a); // ascending
        Arrays.sort(b); // ascending

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((x, y) -> y[0] - x[0]);
        Set<String> visited = new HashSet<>();

        int i = n - 1, j = n - 1;
        maxHeap.add(new int[]{a[i] + b[j], i, j});
        visited.add(i + "#" + j);

        ArrayList<Integer> result = new ArrayList<>();

        while (k-- > 0 && !maxHeap.isEmpty()) {
            int[] top = maxHeap.poll();
            result.add(top[0]);

            int x = top[1], y = top[2];

            // Move left in a[]
            if (x - 1 >= 0 && !visited.contains((x - 1) + "#" + y)) {
                maxHeap.add(new int[]{a[x - 1] + b[y], x - 1, y});
                visited.add((x - 1) + "#" + y);
            }

            // Move up in b[]
            if (y - 1 >= 0 && !visited.contains(x + "#" + (y - 1))) {
                maxHeap.add(new int[]{a[x] + b[y - 1], x, y - 1});
                visited.add(x + "#" + (y - 1));
            }
        }

        return result;
    }
}
