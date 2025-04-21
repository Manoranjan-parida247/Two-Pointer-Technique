//{ Driver Code Starts
// Initial Template for javascript

let inputString = '';
let currentLine = 0;

process.stdin.on('data', inputStdin => { inputString += inputStdin; });

process.stdin.on('end', _ => {
    inputString = inputString.trim().split("\n").map(string => string.trim());
    main();
});

function readLine() { return inputString[currentLine++]; }

function main() {
    let t = parseInt(readLine());
    for (let i = 0; i < t; i++) {
        const arr = readLine().split(' ').map(x => parseInt(x));
        let obj = new Solution();
        let ans = obj.findUnique(arr);
        console.log(ans);
        console.log("~");
    }
}

// } Driver Code Ends

// } Driver Code Ends


class Solution {
    findUnique(arr) {
        // code here
        let result = 0;
        for (let num of arr) {
            result ^= num;
        }
        return result;
    }
}


