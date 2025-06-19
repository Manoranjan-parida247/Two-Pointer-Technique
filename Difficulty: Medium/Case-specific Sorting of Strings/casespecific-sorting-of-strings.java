

class Solution {
    public static String caseSort(String s) {
        List<Character> upper = new ArrayList<>();
        List<Character> lower = new ArrayList<>();

        // Separate characters by case
        for (char ch : s.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                upper.add(ch);
            } else {
                lower.add(ch);
            }
        }

        // Sort both lists
        Collections.sort(upper);
        Collections.sort(lower);

        // Pointers for uppercase and lowercase
        int upperIndex = 0, lowerIndex = 0;
        StringBuilder result = new StringBuilder();

        // Reconstruct the final string
        for (char ch : s.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                result.append(upper.get(upperIndex++));
            } else {
                result.append(lower.get(lowerIndex++));
            }
        }

        return result.toString();
    }
}
