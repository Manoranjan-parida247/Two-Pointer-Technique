

class Solution {
    public String longestString(String[] words) {
        Set<String> wordSet = new HashSet<>();
        Collections.addAll(wordSet, words);

        Arrays.sort(words, (a, b) -> {
            if (b.length() != a.length()) {
                return b.length() - a.length(); // longer first
            }
            return a.compareTo(b); // lexicographically smaller first
        });

        for (String word : words) {
            boolean allPrefixesExist = true;

            for (int i = 1; i < word.length(); i++) {
                String prefix = word.substring(0, i);
                if (!wordSet.contains(prefix)) {
                    allPrefixesExist = false;
                    break;
                }
            }

            if (allPrefixesExist) {
                return word;
            }
        }

        return ""; // If no such word found
    }
}

