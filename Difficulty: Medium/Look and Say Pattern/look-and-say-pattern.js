//{ Driver Code Starts
// Initial Template for javascript
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
    let t = parseInt(readLine());
    let i = 0;
    for (; i < t; i++) {
        let n = parseInt(readLine());
        let obj = new Solution();
        let ans = obj.countAndSay(n);
        console.log(ans);

        console.log("~");
    }
}

// } Driver Code Ends


/**
 * @param {number} n
 * @returns {string}
 */
class Solution {
    countAndSay(n) {
        if (n === 1) return "1";

        let result = "1";

        for (let i = 2; i <= n; i++) {
            let current = "";
            let count = 1;

            for (let j = 1; j < result.length; j++) {
                if (result[j] === result[j - 1]) {
                    count++;
                } else {
                    current += count.toString() + result[j - 1];
                    count = 1;
                }
            }

            // Append the last group
            current += count.toString() + result[result.length - 1];
            result = current;
        }

        return result;
    }
}
