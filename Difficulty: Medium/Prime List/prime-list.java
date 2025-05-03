//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class Node {
    Node next;
    int val;

    public Node(int data) {
        val = data;
        next = null;
    }
}

class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int t;
        t = Integer.parseInt(in.readLine());
        while (t-- > 0) {

            Node head, tail;
            String s[] = in.readLine().trim().split(" ");
            int num = Integer.parseInt(s[0]);
            head = new Node(num);
            tail = head;
            for (int i = 1; i < s.length; i++) {
                num = Integer.parseInt(s[i]);
                tail.next = new Node(num);
                tail = tail.next;
            }
            Solution ob = new Solution();
            Node temp = ob.primeList(head);
            while (temp != null) {
                out.print(temp.val + " ");
                temp = temp.next;
            }
            out.println();
            out.println("~");
        }
        out.close();
    }
}
// } Driver Code Ends


// User function Template for Java
/*
class Node{
    Node next;
    int val;
    public Node(int data){
        val=data;
        next=null;
    }
}
*/

class Solution {
    static final int MAX = 100010;
    static boolean[] isPrime = new boolean[MAX];

    // Sieve of Eratosthenes
    static void sieve() {
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for (int i = 2; i * i < MAX; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < MAX; j += i) {
                    isPrime[j] = false;
                }
            }
        }
    }

    // Get the nearest prime to x
    static int nearestPrime(int x) {
        if (isPrime[x]) return x;

        int lower = x - 1;
        int upper = x + 1;

        while (lower >= 2 || upper < MAX) {
            if (lower >= 2 && isPrime[lower]) return lower;
            if (upper < MAX && isPrime[upper]) return upper;
            lower--;
            upper++;
        }

        return 2; // Fallback (should never hit due to constraints)
    }

    public Node primeList(Node head) {
        sieve();  // Step 1: precompute primes

        Node curr = head;
        while (curr != null) {
            curr.val = nearestPrime(curr.val);  // Step 2: replace with nearest prime
            curr = curr.next;
        }

        return head;
    }
}
