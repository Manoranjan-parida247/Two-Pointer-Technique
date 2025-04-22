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

function main() {
    let tc = parseInt(readLine());
    while (tc > 0) {
        let arr = readLine().split(' ').map(Number);
        // let k = parseInt(readLine());

        let obj = new Solution();
        let res = obj.singleNum(arr);

        console.log(res.join(' ')); // Print the array as a space-separated string
        tc--;
        console.log("~");
    }
}

// } Driver Code Ends


// User function Template for javascript

/**
 * @param {number[]} arr
 * @return {number[]}
 */

class Solution {
    singleNum(arr) {
        // code here
        let xorAll = 0;

        // Step 1: XOR of all elements = x ^ y
        for (let num of arr) {
            xorAll ^= num;
        }

        // Step 2: Get rightmost set bit
        let setBit = xorAll & -xorAll;

        let x = 0, y = 0;

        // Step 3: Divide into two groups and XOR separately
        for (let num of arr) {
            if ((num & setBit) !== 0) {
                x ^= num;
            } else {
                y ^= num;
            }
        }

        return x < y ? [x, y] : [y, x];
    }
}