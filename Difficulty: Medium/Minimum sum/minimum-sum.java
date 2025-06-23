

class Solution {
    String minSum(int[] arr) {
        Arrays.sort(arr); // Sort digits

        // Use StringBuilder to form two numbers
        StringBuilder num1 = new StringBuilder();
        StringBuilder num2 = new StringBuilder();

        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0)
                num1.append(arr[i]);
            else
                num2.append(arr[i]);
        }

        // Remove leading zeros (if any) before adding
        String a = stripLeadingZeros(num1.toString());
        String b = stripLeadingZeros(num2.toString());

        return addStrings(a, b);
    }

    // Adds two string numbers correctly
    private String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();

        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;

        while (i >= 0 || j >= 0 || carry > 0) {
            int n1 = (i >= 0) ? num1.charAt(i--) - '0' : 0;
            int n2 = (j >= 0) ? num2.charAt(j--) - '0' : 0;

            int sum = n1 + n2 + carry;
            sb.append(sum % 10);
            carry = sum / 10;
        }

        // Remove any leading zero after addition (if accidentally generated)
        return stripLeadingZeros(sb.reverse().toString());
    }

    private String stripLeadingZeros(String s) {
        int i = 0;
        while (i < s.length() - 1 && s.charAt(i) == '0') i++;
        return s.substring(i);
    }
}
