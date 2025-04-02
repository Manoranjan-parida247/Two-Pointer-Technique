//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;


// } Driver Code Ends

// User function Template for Java
class Solution {
    // Function to return Breadth First Search Traversal of given graph.
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        int V = adj.size(); // Number of vertices
        ArrayList<Integer> result = new ArrayList<>(); // Stores BFS traversal order
        boolean[] visited = new boolean[V]; // Visited array
        Queue<Integer> queue = new LinkedList<>(); // Queue for BFS
        
        // Performing BFS from each node to handle disconnected graphs
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                queue.offer(i); // Enqueue the starting node
                visited[i] = true;

                while (!queue.isEmpty()) {
                    int node = queue.poll(); // Dequeue a node
                    result.add(node);

                    // Traverse all adjacent nodes
                    for (int neighbor : adj.get(node)) {
                        if (!visited[neighbor]) {
                            queue.offer(neighbor);
                            visited[neighbor] = true;
                        }
                    }
                }
            }
        }
        
        return result;
    }
}


//{ Driver Code Starts.

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {
            int V = Integer.parseInt(br.readLine().trim());
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

            for (int i = 0; i < V; i++) {
                String[] input = br.readLine().trim().split(" ");
                ArrayList<Integer> node = new ArrayList<>();
                for (String s : input) {
                    if (!s.isEmpty()) {
                        node.add(Integer.parseInt(s));
                    }
                }
                adj.add(node);
            }

            Solution obj = new Solution();
            ArrayList<Integer> ans = obj.bfs(adj);
            for (int num : ans) {
                System.out.print(num + " ");
            }
            System.out.println();
            System.out.println("~");
        }
    }
}

// } Driver Code Ends