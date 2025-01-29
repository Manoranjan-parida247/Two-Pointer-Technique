//{ Driver Code Starts
import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            double b = sc.nextDouble();
            int e = sc.nextInt();
            Solution ob = new Solution();
            System.out.printf("%.5f\n", ob.power(b, e));
            System.out.println("~");
        }
        sc.close();
    }
}


// } Driver Code Ends
// User function Template for Java
class Solution {
    double power(double b, int e) {
        // code here
        // Base case
        if (e == 0) return 1;
        if (e < 0) return 1 / power(b, -e);
        
        // Recursive call
        double tempans = power(b, e / 2);
        
        if (e % 2 == 0) {
            return tempans * tempans;
        } else {
            return b * tempans * tempans;
        }
    }
}

//{ Driver Code Starts.
// } Driver Code Ends