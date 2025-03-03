//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;
import java.util.HashMap;


// } Driver Code Ends


class Solution {

    public ArrayList<Integer> longestSubarray(int[] arr, int x) {
        // code here
        int left = 0, right = 0, maxLength = 0, startIndex = 0;
        Deque<Integer> minDeque = new LinkedList<>(); // stores indices of min elements
        Deque<Integer> maxDeque = new LinkedList<>(); // stores indices of max elements
        
        while(right<arr.length){
            // Maintain decreasing order in maxDeque
            while(!maxDeque.isEmpty() && arr[maxDeque.peekLast()] <= arr[right]){
                maxDeque.pollLast();
            }
            maxDeque.addLast(right);
            
            // Maintain increasing order in minDeque
            while(!minDeque.isEmpty() && arr[minDeque.peekLast()] >= arr[right]){
                minDeque.pollLast();
            }
            minDeque.addLast(right);
            
            // if max - min > x, move left pointer to shrink the window
            while(arr[maxDeque.peekFirst()] - arr[minDeque.peekFirst()] > x){
                left++;
                // Remove elements that are out of the new window
                if(!maxDeque.isEmpty() && maxDeque.peekFirst() < left){
                    maxDeque.pollFirst();
                }
                if(!minDeque.isEmpty() && minDeque.peekFirst() < left){
                    minDeque.pollFirst();
                }
            }
            if(right-left+1>maxLength){
                maxLength = right - left + 1;
                startIndex = left;
            }
            right++; 
        }
        ArrayList<Integer> result = new ArrayList<>();
        for(int i = startIndex; i<startIndex+maxLength; i++){
            result.add(arr[i]);
        }
        return result;
    }
}


//{ Driver Code Starts.
public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            int k = Integer.parseInt(br.readLine());
            // Create Solution object and find closest sum
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.longestSubarray(arr, k);

            // Print the result as a space-separated string
            for (int num : ans) {
                System.out.print(num + " ");
            }
            System.out.println(); // New line after printing the results
            System.out.println("~");
        }
    }
}

// } Driver Code Ends