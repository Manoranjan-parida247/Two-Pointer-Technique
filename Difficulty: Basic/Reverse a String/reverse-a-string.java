// User function Template for Java

class Solution {
    public static String reverseString(String s) {
        // code here
        char[] arr = s.toCharArray();
        
        int left = 0;
        int right = s.length() - 1;
        
        while(left < right){
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
        
        return  new String(arr);
        
    }
}