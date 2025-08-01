

class Solution {
    public int countBalanced(String[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // diff 0 seen once (empty prefix)
        
        int diff = 0; // vowel - consonant
        int count = 0;
        
        for (String s : arr) {
            int vowels = 0, consonants = 0;
            for (char ch : s.toCharArray()) {
                if (isVowel(ch)) vowels++;
                else consonants++;
            }
            
            diff += (vowels - consonants);
            
            count += map.getOrDefault(diff, 0);
            
            map.put(diff, map.getOrDefault(diff, 0) + 1);
        }
        
        return count;
    }
    
    private boolean isVowel(char ch) {
        return "aeiou".indexOf(ch) != -1;
    }
}
