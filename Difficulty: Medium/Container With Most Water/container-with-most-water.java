//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Sorting {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) arr[i] = Integer.parseInt(str[i]);
            System.out.println(new Solution().maxWater(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    public int maxWater(int arr[]) {
        // Code Here
        int n = arr.length;
        if (n < 2) {
            return 0; // Not enough lines to hold water
        }

        int left = 0, right = n - 1;
        int maxWater = 0;

        while (left < right) {
            // Calculate the width of the container
            int width = right - left;

            // Calculate the height of the container as the min of the two lines
            int height = Math.min(arr[left], arr[right]);
            
            // Calculate the area and update the maximum water
            int currentWater = width * height;
            maxWater = Math.max(maxWater, currentWater);

            // Move the pointer of the shorter line inward
            if (arr[left] < arr[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxWater;
    } 
}