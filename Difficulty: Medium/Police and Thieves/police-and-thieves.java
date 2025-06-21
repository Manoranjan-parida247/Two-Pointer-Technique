class Solution {
    public int catchThieves(char[] arr, int k) {
        // code here
         int n = arr.length;
        Queue<Integer> police = new LinkedList<>();
        Queue<Integer> thieves = new LinkedList<>();
        int caught = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] == 'P') {
                police.add(i);
            } else if (arr[i] == 'T') {
                thieves.add(i);
            }

            // Try to match as long as both queues have entries
            while (!police.isEmpty() && !thieves.isEmpty()) {
                int p = police.peek();
                int t = thieves.peek();

                if (Math.abs(p - t) <= k) {
                    caught++;
                    police.poll();
                    thieves.poll();
                } else if (t < p) {
                    thieves.poll(); // thief is too far behind
                } else {
                    police.poll(); // police is too far behind
                }
            }
        }

        return caught;
    }
}