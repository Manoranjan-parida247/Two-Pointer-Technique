/**
 * @param {string} s
 * @param {number} k
 * @returns {number}
 */
class Solution {
    minValue(s, k) {
        // code here
        const freqMap = new Map();

    // Count frequency of each character
    for (const ch of s) {
        freqMap.set(ch, (freqMap.get(ch) || 0) + 1);
    }

    // Convert frequencies into a max heap using a priority queue approach
    const maxHeap = [...freqMap.values()];
    maxHeap.sort((a, b) => b - a); // max-heap using sort

    while (k > 0 && maxHeap.length > 0) {
        let top = maxHeap.shift(); // get max frequency
        top -= 1;
        k -= 1;
        if (top > 0) {
            // insert back in sorted position
            let i = 0;
            while (i < maxHeap.length && maxHeap[i] > top) i++;
            maxHeap.splice(i, 0, top);
        }
    }

    // Calculate final value
    return maxHeap.reduce((sum, freq) => sum + freq * freq, 0);
        
        
    }
}
