//{ Driver Code Starts
'use strict';

process.stdin.resume();
process.stdin.setEncoding('utf-8');

let inputString = '';
let currentLine = 0;

process.stdin.on('data', inputStdin => { inputString += inputStdin; });

process.stdin.on('end', _ => {
    inputString =
        inputString.trim().split('\n').map(string => { return string.trim(); });

    main();
});

function readLine() { return inputString[currentLine++]; }

function printList(res, n) {
    let s = "";
    for (let i = 0; i < n; i++) {
        s += res[i];
        s += " ";
    }
    console.log(s);
}

function main() {
    let t = parseInt(readLine());
    let i = 0;
    for (; i < t; i++) {
        const n = parseInt(readLine()); // Fixed: add readLine() to get input for n
        const r = parseInt(readLine()); // Fixed: add readLine() to get input for r
        let obj = new Solution();
        let res = obj.nCr(n, r);
        console.log(res);
        console.log("~");
    }
}

// } Driver Code Ends


// User function Template for javascript

/**
 * @param {number} n
 * @param {number} r
 * @returns {number}
 */

class Solution {
    // Method to calculate nCr (Binomial Coefficient)
    nCr(n, r) {
        if (r > n) return 0;

        if (r === 0 || r === n) return 1;

        // Take advantage of symmetry: nCr == nC(n-r)
        if (r > n - r) r = n - r;

        let res = 1;

        // Calculate value of [n * (n-1) * ... * (n-r+1)] / [r * (r-1) * ... * 1]
        for (let i = 0; i < r; i++) {
            res *= (n - i);
            res /= (i + 1);
        }

        return res;
    }
}

