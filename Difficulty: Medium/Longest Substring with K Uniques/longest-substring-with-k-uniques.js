/**
 * @param {string} s
 * @param {number} k
 * @returns {number}
 */
class Solution {
  longestKSubstr(s, k) {
    if (k === 0 || s.length === 0) return -1;

    const freq = new Map();     // char → count in window
    let left = 0;
    let maxLen = -1;

    for (let right = 0; right < s.length; right++) {
      // add current character to the window
      const ch = s[right];
      freq.set(ch, (freq.get(ch) || 0) + 1);

      // shrink window until we have ≤ k distinct characters
      while (freq.size > k) {
        const leftChar = s[left++];
        const cnt = freq.get(leftChar) - 1;
        if (cnt === 0) freq.delete(leftChar);
        else freq.set(leftChar, cnt);
      }

      // if exactly k distinct chars, update answer
      if (freq.size === k) {
        maxLen = Math.max(maxLen, right - left + 1);
      }
    }

    return maxLen;              // −1 if no valid substring was found
  }
}

