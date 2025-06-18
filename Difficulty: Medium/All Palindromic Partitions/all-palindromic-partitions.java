class Solution {
    public ArrayList<ArrayList<String>> palinParts(String s) {
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        ArrayList<String> path = new ArrayList<>();
        backtrack(0, s, path, result);
        return result;
    }

    private void backtrack(int start, String s, ArrayList<String> path, ArrayList<ArrayList<String>> result) {
        if (start == s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int end = start; end < s.length(); end++) {
            String substring = s.substring(start, end + 1);
            if (isPalindrome(substring)) {
                path.add(substring); // choose
                backtrack(end + 1, s, path, result); // explore
                path.remove(path.size() - 1); // un-choose
            }
        }
    }

    private boolean isPalindrome(String str) {
        int l = 0, r = str.length() - 1;
        while (l < r) {
            if (str.charAt(l++) != str.charAt(r--))
                return false;
        }
        return true;
    }
}
